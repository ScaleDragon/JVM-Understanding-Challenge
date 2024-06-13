
    public class JvmComprehension {

       public static void main(String[] args) {
          int i = 1;                      // 1
          Object o = new Object();        // 2
          Integer ii = 2;                 // 3
          printAll(o, i, ii);             // 4
          System.out.println("finished"); // 7
        }

        private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5
        System.out.println(o.toString() + i + ii);  // 6
        }
    }

    /*
     >Process ClassLoader:
     Загрузчик классов: Classloader отвечает за загрузку Java-классов с диска в память JVM, 
     разрешение зависимостей между классами и инициализацию классов во время выполнения программы. 
     Загрузчик классов следует иерархии делегирования, начиная с Bootstrap Classloader, затем Extension Classloader и Application Classloader.
    a)  Запускается подсистема загрузки классов ClassLoader для поиска и  
    загрузки классов(в данном примере "JvmComprehension")
    b)  Процесс связывания устанавливает связи между классами и проверяет их на наличие несоответствий или ошибок. Связывание состоит из трех этапов:

    Верификация: На этом этапе JVM убеждается, что загруженные файлы классов соответствуют структуре и ограничениям, указанным в спецификации языка Java.
     Некорректные или вредоносные файлы классов на этом этапе будут отклонены.
   
    Подготовка: JVM инициализирует статические поля, методы и другие ресурсы, необходимые для выполнения класса. Она присваивает статическим полям 
    значения по умолчанию и выделяет под них память.
    
    Разрешение: На этом этапе происходит разрешение символьных ссылок в файлах классов путем замены их на прямые ссылки, такие как адреса методов 
    и смещения полей. Этот процесс выполняется динамически во время выполнения программы.

    c)  Инициализация класса(выполняются статические инициализаторы полей, методов, объектов).

    Во время выполнения программы JVM выделяет области памяти, называемые Runtime Data Areas. 
    Эти области памяти включают в себя Heap, Stack, Method Area, Constant Pool и PC Registers,
    в которых хранятся данные, необходимые для различных аспектов жизненного цикла приложения.
    JVM хранит весь статический контент в этом разделе памяти. 
    Сюда входят все статические методы, примитивные переменные и ссылки на статические объекты.

  Запускается выполнение метода "main" и в этот момент создается фрейм в стеке(на каждый метод свой фрейм)
  Этот фрейм(в стеке) заполняется инициализированными примитивами(1) и ссылками на объекты(2 -> " Object o",
3 -> Integer ii). Вместе с этим, новосозданные объекты (2 -> " new Object()",
3 -> Integer ii =2), помещаются в "кучу", которые связаны с сылками из стека.

При запуске следующего метода (4)"printAll" создается еще один фрейм со своими данными из пармаметров(ссылки на объекты -> Object o,
Integer ii, которые связаны с теми же объектами из кучи, т.к. ссылки одинаковые,и примитивные типы(1)) и новые 
инициализировнные объекты(5).   
Внутри метода "printAll" выполняется запуск System.out.println(6) с созданием своего фрейма с данными.

>Process Execution Engine
Происходит выполнение кода.Компилятор Just-In-Time (JIT) отвечает за преобразование байткода Java в нативный машинный код 
во время выполнения программы. Этот процесс позволяет оптимизировать скорость выполнения Java-приложений. JIT-компилятор 
компилирует часто вызываемые методы, кэширует скомпилированный код и повторно использует его при последующих выполнениях,
снижая затраты на повторную интерпретацию байткода.

>Garbage Collection
ВJVM использует стратегию сборки мусора по поколениям, разделяя кучу памяти на молодое и старое поколения. Молодое поколение далее подразделяется
 на Eden Space, Survivor Space 0 (S0) и Survivor Space 1 (S1).

                                 */

