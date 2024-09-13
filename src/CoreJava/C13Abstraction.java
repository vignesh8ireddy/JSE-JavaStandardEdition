package CoreJava;/*
 Abstract Keyword allows java programmers to define a method only with the
 method signature and without any method implementation. This is to allow subclasses
 to override this method for their own version.

 If a class has atleast one method declared as abstract then the class also must be
 declared as abstract.

 only methods (and so classes) can be declared as abstract; variables cannot be abstract

 Instantiation of an abstract class is not possible. Because it is incomplete class. But,
 you can create references for an abstract class, though it is abstract it is reference data type

 An abstract class cannot be declared as final because it must be allowed to be inherited
 by some other class because it is incomplete.
 Similarly, abstract methods also cannot be final.

 A class can be declared as abstract even if it doesn't has any abstract methods. Doing so
 will make class incomplete (though its not) and un-instantiable

 constructor cannot be abstract (because the inbuilt definition of constructor has super() in its first line.
 java has already a definition for constructor.)

When you create an object of sub-class, memory is allocated to not only its members but also to the
members of its superclass because sub-class also contains members of its super-class along with
its own.

 */

abstract class Shape{
    double dim1;
    double dim2;

    void input(double d1, double d2) {
        dim1 = d1;
        dim2 = d2;
    }

    abstract double area();
}

class Rectangle extends Shape{
    double area() {
        return dim1*dim2;
    }
}

class Triangle extends Shape{
    double area() {
        return 0.5*dim1*dim2;
    }
}

/*
 A class which has only abstract methods is interface
 i.e 100% abstraction. A class with only method signatures

 In interface no need to specify abstract keyword and access
 specifier for methods, by default THEY ARE ABSTRACT AND PUBLIC.
 interface keyword itself gives all the information to JVM.
 Access specifier cannot be other than public. you cannot
 explicitly specify any other access specifiers

 Interface is requirement specification of a class. It is a
 blue print of a class.

 Though you cannot create instance for an interface you can create references
 for it.

 */

interface Calculator{
    void add(int a, int b);//public abstract void add();
    public abstract void sub(int a, int b);//no harm if you specify access modifier and "abstract" explicitly;
}

class MyCalculator1 implements Calculator{//only class' name with file name can be public class
    //this class must override ALL methods of interface
    //i.e this class must implement all methods of the interface

    public void add(int a, int b) {//must be public, cannot reduce visibility while overriding
        System.out.print("Calculator1: ");
        System.out.println(a+b);
    }

    public void sub(int a, int b) {
        System.out.print("Calculator1: ");
        System.out.println(a-b);
    }

    public void mul(int a, int b) {//you can have other methods along with overriding methods
        System.out.print("Calculator1: ");
        System.out.println(a*b);
    }

}

class MyCalculator2 implements Calculator{//only class' name with file name can be public class
    //this class must override ALL methods of interface

    public void add(int a, int b) {//must be public, cannot reduce visibility while overriding
        System.out.print("Calculator2: ");
        System.out.println(a+b);
    }

    public void sub(int a, int b) {
        System.out.print("Calculator2: ");
        System.out.println(a-b);
    }

    public void mul(int a, int b) {//you can other methods along with overriding methods
        System.out.print("Calculator2: ");
        System.out.println(a*b);
    }

}

interface DCalculator{
    void mul(int a, int b);//public abstract void mul();
    void div(int a, int b);//public abstract void div();
}

//A class can implement more than one interfaces
//i.e java supports multiple implementations though it doesn't support multiple inheritances

class MyCal implements Calculator,DCalculator{
    public void add(int a, int b) {
        System.out.println(a+b);
    }
    public void sub(int a, int b) {
        System.out.println(a-b);
    }
    public void mul(int a, int b) {
        System.out.println(a*b);
    }
    public void div(int a, int b) {
        System.out.println(a/b);
    }
}

//A class can inherit a class and implement an interface at a time

class MyCalculator3 extends MyCalculator1 implements Calculator{
    //but first it must inherit and then implement
}


//An interface cannot implement another interface
//but an interface X can extend another interface Y and any class which implements X must
//give definitions for all methods in X and all methods in Y


//An interface can have variables but those variables must be public, static, and final
//public, so that all classes implementing them must access it
//static, because java interfaces cannot be instantiated on their own.
//final, interfaces are allowed to declare only constant variables but not instance variables


//An empty interface is allowed in java, it is called Marker Interface or Tagged interface


/*

An interface that does not have any methods, fields, or constants, i.e., an empty interface in java, is known as a Marker or Tag Interface.
It is used to deliver type information at runtime to the JVM so that it can take some action based on the information received.
One of the main purposes behind the ideology of marker interfaces is to convey to the JVM that the class implementing this type of interface
has some extra functionalities.
Popular examples of marker interfaces in Java include Cloneable, Serializable, Remote Interface.

 interface Interface1{

 //this is a marker interface

 }
 */

//An interface with only one method signature(single abstract method) is called "functional interface"
//functional interface can be implemented using normal class/anonymous inner class/lambda expression

@FunctionalInterface
interface FInterface{
    void dispK();
}

//normal class
class TempK implements FInterface{
    public void dispK() {
        System.out.println("K");
    }
}




//An interface can have a method with its full implementation but it must be specified as "default"
//default method's implementation in implementing class is optional
//we can also have static methods in Interface but they cannot be overridden as usually
//from java 9 interface can also have private method signatures but they won't participate in implementation
//private static methods are also allowed in interface but they cannot be implemented/overridden/hidden, this
//method can be called by only static methods in the interface
interface Interface12{
    void dispMe();
    default void showMe() {
        System.out.println("Hi, I'm default Method");
        //if overridden, implementation changes
        sayBye();
    }
    static void sayHi() {
        System.out.println("Hi...!!");
        //this static method cannot be overridden instead this can be hidden permanently
    }
    private void sayBye() {
        System.out.println("Bye!");
        //this method can be used only locally
        //i.e this method can be called by either default methods or static methods
    }
}

class TTInterface implements Interface12{
    public void dispMe() {
        //
    }

    static void sayHi() {
        //superclass static method is hidden now
    }
}

//abstract class can have constructor: In abstract class, we have an instance variable, abstract methods, and non-abstract methods.
//We need to initialize the non-abstract methods and instance variables, therefore abstract classes have a constructor
//but an interface cannot have any constructor



public class C13Abstraction {

    public static void main(String[] args) {

        Rectangle r = new Rectangle();
        r.input(20, 30);
        System.out.println(r.area());//600.0

        Triangle t = new Triangle();
        t.input(20, 30);
        System.out.println(t.area());//300.0

        MyCalculator1 mcal = new MyCalculator1();
        mcal.add(20, 30);//50
        mcal.sub(50, 10);//40
        mcal.mul(10, 5);//50

        //though we cannot create objects for interfaces we can use their reference type for polymorphism
        //achieving polymorphism using interface
        Calculator cal1 = new MyCalculator1();
        Calculator cal2 = new MyCalculator2();
        cal1.add(10, 10);
        cal1.sub(10, 10);
        //cal1.mul(10, 10); upcasting: cannot access subclass' instance methods
        cal2.add(10, 10);
        cal2.sub(10, 10);
        //cal2.mul(10, 10); upcasting: cannot access subclass' instance methods

        Interface12 X = new TTInterface();
        X.showMe();//"Hi, I'm default Method"


        //anonymous inner class implementation for functional interface
        FInterface FIObj = new FInterface() {
            public void dispK() {
                System.out.println("K");
            }
        };
        FIObj.dispK();//"K"



        //lambda expression : ->
        FInterface FIObj2 = () -> {
            System.out.println("lambda expression implementation");
        };
		/* or u can write lambda expression as follows as well
		 FInterface FIObj2 = () -> System.out.println("lambda expression implementation");
		 */

		/*
		 let's say that the dispK() function has following definition

		 int dispK(int n){
		 	System.out.println(n);
		 	return n;
		 }

		 then,
		//anonymous inner class implementation for functional interface
		FInterface FIObj = new FInterface() {
			public int dispK(int x) {//or public int dispK(x) you can remove int
				System.out.println("K"+x);
				return x;
			}
		};

		//lambda expression : ->
		FInterface FIObj2 = (int x) -> { //or FInterface FIObj2 = (x)
				System.out.println("lambda expression implementation");
				return x;
		};

		 */

        FIObj2.dispK();//"lambda expression implementation"
    }

}

