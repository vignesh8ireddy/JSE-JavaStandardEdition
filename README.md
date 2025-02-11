## JSE - Java Standard Edition

* Data Types
  * Primitive Types
    * byte, short, int, long, float, double, char, boolean
  * Reference Types
    * String, Number, Integer, Character, Exception, etc
* Literals
  * Numerical literals
    * int(default), long, float, double(default) literals (binary, decimal, octal, hexadecimal)
  * char literals (unicode char literals, ascii values)
  * boolean literals (true, false)
  * String literals 

* Four Basic types of class members:
  1. Data Variables: Declaration and Definition(=Declaration+initialisation)
  2. Blocks
  3. Constructors
  4. Methods 
  * Within it's body, a class can have only above four. 
  * It's not possible to have executable code within class body:
  <br> System.out.println("Class body"); // Error, executable code
  <br> i=32; //Error, executable code
  * Executable code shall be present only inside block, constructor or method 
  * If local variables (stored in stack area) are tried to access without initialising, there would be a compile-time error.
  * But if instance variables (stored in heap area) are tried to access without initialising, there
  wouldn't be any error but gives garbage value (zero mostly).

  >  1. After compilation of code, java class is loaded from .class file
  >  2. Static members are assigned memory during compile-time itself.
  >  3. When class is loaded, first of all, static blocks are executed in the order.
  >  4. Then, during it's Object creation, memory would be assigned to non-static members.
  >  5. After that, all the normal blocks would be executed in the order
  >  6. Then, constructor would be executed 
  > <br> A class will be loaded before creation of its object.
    If no object is created for a class then, the class is not loaded.

* Constructor 
  * The main use of a constructor is to avoid setter methods
  * If you didn't provide ANY constructor in for a class then JVM by would call the default parameterless constructor.
  * If you provide even at least one constructor then, JVM will not provide any constructor. So, you must call one 
    of the constructors you gave for the class while creating object for it.
  * Constructor Chaining
    * super() and this()
  > class constructor can not be static, final and abstract;<br>
  > One of the important property of java constructor is that it can not be static. 
     We know static keyword belongs to a class rather than the object of a class. 
     A constructor is called when an object of a class is created, so no use of the static constructor.
  > <br> Constructors are not inherited in java. Therefore, constructors are not subject to hiding or overriding.
  > When there is no chance of constructor overriding, there is no chance of modification also. When there is
  > no chance of modification, then no sense of restricting modification there.
* Immutable String 
  * strings which are objects of String class are immutable
    i.e they cannot be modified once they are created
  * Methods to useful while working on strings
    1. == : compares string references i.e addresses of string objects
    2. equals() : compares string objects i.e values/literals
    3. equalsIgnoreCase() : literals will be compared case is not significant
    4. compareTo() : compares char by char returns which is greater acc. to lex order
    5. concat() : generates new string which is concatenation of given strings
    6. subString(int,int)
    7. toUpperCase()
    8. toLowerCase()
    9. length()
    10. charAt()
    11. hashCode()
  * SCP - String Constant Pool present in Heap area
  * plus operator overloading when string as one of its operator
  * Static keyword
    * static keyword is used to access members of class without creating object.
    <br> so, static keyword is attached to only members of class (except constructor)
    <br>  static variables: (possible)
    <br>  static blocks   (possible)
    <br>  static methods  (possible)
    <br>  static constructor (meaningless and impossible)

    * static when attached to a variable, a method or a block makes it the class variable, the class method
      and the class block.
      * static variables/methods are accessed using ClassName.
      * static blocks are executed when the class is loaded and memory is deallocated for the block
    * static variables are created and allocated memory(in heap) during compile-time itself
    * They aren't instance variables (=> accessed using classname not objectname)
    * Everyone can access them (and they are common for everyone)
    * static members can only access static members i.e static methods and static
      blocks can access only static variables and call static methods but cannot
      access non-static members because while static elements are getting executed
      non-static members are not even got created.
    * But non-static members can access static members.
    ```java
    public class KeywordStatic {
      static int x,y,z;
      int a;

      static void display() {

          System.out.println("Static Method");
          System.out.println(x+" "+y+" "+z);

      }

      {
          System.out.println("Normal Block");
          System.out.println("a = "+a);
      }

      static {//Executed first
          System.out.println("Static Block");
          x=10;
          y=20;
          z=30;
      }

      KeywordStatic(){
          System.out.println("constructor");
          a=50;
          System.out.println("a = "+a);
      }
    
      public static void main(String []args) {
          System.out.println("Main Method starts");
          display();
          System.out.println("An Object is created next line");
          KeywordStatic KS=new KeywordStatic();
          System.out.println("Main Method ends");

      }
    
    }
    /*
    output:
    Static Block
    Main Method starts
    Static Method
    10 20 30
    An Object is created next line
    Normal Block
    a = 0
    constructor
    a = 50
    Main Method ends
	*/
    ```
  * Static members are created only once, at the time of class loading
    in Heap and they global and common to all the instances of the class
  * Instance variables are created everytime an instance is created during
      runtime in Heap and they are local to the corresponding instance
  * Use static variables whenever you want global variables that can be
        accessed and modified by any instance of the class
  * Can static blocks call:
    * static variables ✔
    * static methods ✔
    * non static variables ❌
    * non static methods ❌
    <br> but you can create an instance for the class and call non static variables and non static methods
    same goes with static methods calling non static members.(That's what you do with main method in java)
* Final Keyword