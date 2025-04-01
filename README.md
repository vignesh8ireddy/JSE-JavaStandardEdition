## JSE - Java Standard Edition

* Java is a very simple, high-level, secured, multithreaded, platform independent, object-oriented programming language.
* Java is descendent of C and C++.
* Java Features
    * Simple
    * Secure
    * Robust
    * Portable
    * Architecture neutral
    * Object Oriented
    * Multithreaded
    * High performance
    * Distributed
    * Dynamic
* Based on it's features Java can be more precisely defined as, a high-level programming language which is simple,
  secure, robust, portable, object-oriented, interpreted, byte coded, architectural-neutral (i.e platform independent),
  garbage collected, multithreaded programming language with strongly typed exception handling mechanisms for developing
  distributed, dynamically extensible applications.
* Unlike others, Java technology is both platform and programming language
    * Platform is software environment in which programs executed, JVM is the platform owned by Java.
* Java Mirco Edition for developing Mobile Applications
* Java Standard Edition for developing Standalone applications.
* Java Enterprise Edition for developing Web Applications
* Android was developed using Java and it had been primary language of Android for long time before Kotlin took its
  place.
* Platform Dependent: An application that is compiled in one operating system and cannot run in different OS.
    * If an application's compiled code is able to run in different operating system then that application is platform
      independent.
    * Java is platform independent because compiled code of a java program can run in all Operating Systems.
* Web Application - An application that resides in server and that is executed directly in server system via network
  call and sending response back to client.
    * Servlet to process request
    * JSP to send response (outdated, instead send response as JSON objects via API)
* Java is most preferred language for developing web applications because they must be platform independent i.e must run
  in all operating systems irrespective of where it is compiled.
* Java compiler generates bytecode and JVM translates it into machine language for any OS (Windows, Linux, iOS,..)
  accordingly. C and C++ generates machine language directly for the current OS.
* .java file has java source code developed by the programmers, .class file has byte code compiled by the java compiler,
  C and C++ compilers generate .exe files directly.
* Because JVM is available on all the OS, .class files are enough to run the programs in any OS. That's why the famous
  Java's slogan has emerged - "Write Once, Run Anywhere".
* Java Compiler is also OS independent because it takes .java file and generates .class file which are OS independent.
* JVM is OS dependent obviously because it has to generate machine language specific to the OS by taking .class file.
    * So, Java programs/applications are platform independent, Java Software itself is platform dependent.
* Types of Java Software
    * JDK (Java Development Kit): Contains Java Compiler and JVM, used for developing new applications and running them.
    * JRE (Java Runtime Environment): Contains only JVM, used for running already developed applications.
    * JDK is used in Development environment, JRE is used in Testing and Production environment.
* JVM version < Java Compiler version leads to Unsupported Major_Minor exception
    * Always, JVM version >= Java Compiler
* Path environment variable - Used by OS to identify binary files (i.e .exe, .bat, .cmd,.. files)
* Classpath environment variable - Used by Java compiler and JVM to identify Java library files (i.e .jar, .class files)
* A java program elements
    * Package
        * class
            * variables
            * methods
                * variables
        * interface
            * variables
            * methods
        * enum
            * variables
            * methods
                * variables


* Control Statements
* Object Oriented Programming
* JVM Architecture
* Garbage Collection
* String Handling
* Wrapper Classes
* Exception Handling
* Multithreading
* IOStreams (File IO)
* Collection Framework
* Reflection API
* Inner Classes
* Date, time and text format
* Annotations


* Enum is introduced in java 5 to create set of named constants for creating menu kind of items.

* Java Vs C Vs C++ Vs C#




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
* Operators
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


* Wrapper Classes (introduced in java 1.5)
  * Wrapper classes are used to wrap primitive data types into object data types so that we can 
    handle primitive types like objects.
  * Using Wrapper classes we define several utility functions which are useful while working with primitive types. 
  * Wrapper classes are a part of "java.lang" package. 
  * All wrapper class objects are immutable just like objects of String class
  * For every primitive type we have equivalent Wrapper class as shown below 
    * byte -> Byte class; has two constructors/ one takes byte and other String 
    * short -> Short class; has two constructors/ one takes short and other String 
    * int -> Integer class; has two constructors/ one takes int and other String 
    * long -> Long class; has two constructors/ one takes long and other String 
    * float -> Float class; has three constructors/ one takes float, one double and other String 
    * double-> Double class; has two constructors/ one double and other String 
    * char -> Character class (has only 1 constructor that has char as argument)
    * boolean -> Boolean class (2 constructors, one with boolean, one with String argument is important))
  * Almost every Wrapper class contains 2 constructors of which
    1. takes corresponding primitive type as the argument.
    2. takes equivalent String type as the argument.
    * If the equivalent string input is not properly formatted, meaning if it is not representing any
      number then compiler would throw "NumberFormatException"
    * Character class contains only one constructor which can take only primitive
      argument of type char. It doesn't have a constructor taking String type argument because we cannot have a String
      equivalent to char, ("a" is String not char 'a')
    * In String constructor of Boolean class, if we pass case insensitive String of true then it is treated as
         true and in all other cases it is false.
    
  * In all wrapper classes toString() of Object class is overridden to return the primitive value present in 
    the Object instead of reference hash value.
  * equals() method of Object class is also overriden in all Wrapper
    classes to compare content instead of reference variables.
  * 4 Utility methods of Wrapper classes
    * All utility methods are static (so you can directly use them with Wrapper class name).
    1. valueOf()
       > method signature: public static WrapperClass valueOf(primitive data)
                      <br> public static WrapperClass valueOf(String data)

       * It is used to create Wrapper class instance from primitive types and properly formatted Strings.
       * It is an alternative to using constructor to create Wrapper class instance and
       using valueOf() for creating Wrapper class instances is best way rather than
       using constructor because the latter way is deprecated

    2. xxxxValue() // xxxx = any primitive datatype (byte,short,int,long,float,double,char,boolean)

       > method signature: public static xxxx xxxxValue();
       * It is used to return primitive data types from Wrapper class types
       * Every Numeric type wrapper class (Byte, Short, Integer, Long, Float, Double) has
         these 6 methods : byteValue(), shortValue(), intValue(), longValue(), floatValue()
          and doubleValue()
       * charValue() and booleanValue() methods are not defined in Numeric type wrapper classes.
       * Character wrapper class has only charValue() method
       * Boolean wrapper class has only booleanValue method

    3. parseXxxx() // Xxxx = any primitive datatype (byte,short,int,long,float,double,char,boolean)
       > method signature: public static xxxx ParseXxxx(String data);
       * Every Wrapper class except Character class has parseXxxx() method to convert String to xxxx primitive type

    4. toString()
       > method signature: public static String toString(primitive data) corresponding primitive type to String
                       <br> public static String toString()//Wrapper class content to String

       * Used to convert Wrapper object and primitive data to String type.

* Object class methods
  * Use this command in command prompt to get all methods of Object class : 
  > javap java.lang.Object
  <pre>
  public class java.lang.Object {
      public java.lang.Object();
      public final native java.lang.Class<?> getClass();
      public native int hashCode();
      public boolean equals(java.lang.Object);
      protected native java.lang.Object clone() throws
      java.lang.CloneNotSupportedException;
      public java.lang.String toString();
      public final native void notify();
      public final native void notifyAll();
      public final native void wait(long) throws java.lang.InterruptedException;
      public final void wait(long, int) throws java.lang.InterruptedException;
      public final void wait() throws java.lang.InterruptedException;
      protected void finalize() throws java.lang.Throwable;
      static {};
  }
  </pre>


## Java 5 features (Tiger)
1. static import
2. @Override annotation
3. covariant returns
4. Autoboxing & Auto unboxing
5. Var-arg parameter method
6. for-each (i.e enhanced for loop)
7. Generics
8. Enumerations
9. Annotations (meta-data)
10. java.lang.concurrent package (collection api with thread safety)
11. C style formatting input and output
12. Scanner class

Java 5 is a failed version, because of all the above features, its execution has become slow
and to solve this Java 6 has came.

## Java 6 features (Mustang)
1. Console
2. NavigableSet & NavigableMap

## Java 7 features (Dolphin)
1. Execution flow change with respect to main method
2. Binary Literal is also introduced to decimal, octal and hexadecimal integer literals
3. Underscore in number literal
4. Switch with String argument
5. try with resource
6. Catch with multiple exception classes
7. Generic type inference (<>)
8. var-arg bug fix in overloading and overriding methods

In 2010, Oracle corporation acquired Sun Microsystems including java

## Java 8 features

1. Default Methods in interface
2. Static Methods in interface
3. Functional Interface, @FunctionalInterface annotation, Lambda Expression
  * Functional Interface is SAM i.e Single Abstract Method Interface
  * Comparable, Comparator, Runnable, Callable,... are few functional interfaces
  * Functional interface is used for enabling Functional Programming to java.
  * Functional interface is also used for defining lambda expressions to pass a function
    directly as an argument to method.
  * Because we define lambda expression from functional interface, we can also say a functional
    interface is a Base type/ Super type of the Lambda Expression
  * Two ways of creating functional interface:
    1. effectively creating a functional interface
       ```java
       //you are commited to not add any other method signature to below interface
       //that's why is effective
       interface Addition {
            void add(int a, int b);
       }
       ```
    2. using @FunctionalInterface i.e explicitly declaring:
       ```java
       // if you try to add any other method signature, compiler throws error
       // i.e you are forcing the below interface to be a functional interface
       @FunctionalInterface
       interface Addition {
           void add(int x, int y);
       }
       ```
  * The following are the programming elements that are allowed to place in the
    functional interface:
    1. public static final fields
    2. public static inner classes
    3. public default implemented methods
    4. public static implemented methods
    5. private static and non-static methods (java 9+)
    6. 11 methods of java.lang.Object as abstract methods
    7. only one public abstract method
  * Inheritance among functional interfaces
    ```java
    @FunctionalInterface
    interface F1 {
       void m1();
    }
    
    @FunctionalInterface
    interface F2 extends F1 {//throws error, because 2 public abstract methods
       void m2();
    }
    
    @FunctionalInterface
    interface F3 extends F1 {//allowed because only one public abstract method
    }
    
    @FunctionalInterface
    interface F4 extends F1 {//allowed
       public default void m4();
    }
    ```
  * Generic Functional Interface
    ```java
    @FuntionalInterface
    interface F1<T> {
      T m1(T a, T b);
    }
    
    @FunctionalInterface
    interface Addition<T extends Number> {
      T add(T a, T b);
    }
    ```
  * Lambda Expression
    * A Lambda Expression is an anonymous function, it is an implementation of a functional interface.
    * Lambda Expression doesn't have a name, return type, access modifier, execution level modifier or exception list.
    * It has parameters and function definition
    * Expression is a combination of operator and operand
    * Here, operator is ->, two operands are arguments and function definition
    * -> operator returns instance of the functional interface implementing it.
    * Lambda Expression is an object which is an instance of one functional interface implementation.
    * So every lambda expression implicitly has a name, return type, access modifier, execution level modifier and exception list
      in the functional interface which it has implemented
    * It is an alternate to Anonymous Inner Class
    * Lambda Expression Syntax
      ```java
      @FunctionalInterface
      interface IFunInterfaceImpl {
          void add(int x, int y);
      }
      /*
      IFunInterface IFunInterfaceImpl = (a,b) -> { System.out.println(a+"+"+b"=");
                                                   System.out.print(a+b);
                                                  };
      IFunInterfaceImpl.add(15,20);
      */
      ```

4. Functional API (java.util.function)
  * Consumer<T>
  * Supplier<T>
  * Function<T,R>
  * Predicate<T>
5. Method and Constructor reference (::)
6. forEach() method and specialIterator method in Iterable interface
7. Stream API (java.util.stream)
8. New Date & Time API
9. Optional API

* Java Keywords

## Zephyr

* Why is Java named after a coffee?
* Why java doesn't have features like pointers, structure, union, operator overloading, multiple inheritance, etc.
* Like C or C++ programs, Java programs are not directly executed by OS, then how they are executed?
* JDK X JRE X JVM
*