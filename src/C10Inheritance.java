public class C10Inheritance {

    /*

	> Java doesn't support multiple inheritance because of ambiguity problem:
		 class A and class B both have display() method if class C extends both
		 A and B classes then whose display() definition C has to inherit?

    > Java does support multi-level inheritance though
    > every class inherits Object class so, every class' instances can use
      methods(like toString(), et cetera) of Object class

	*/

    public static void main(String []args) {
        A a=new A();//loads class A and instantiates object a
        B b=new B(); /* Here, first loads and instantiates class A (super class of B)
        in memory space of B, then class B is loaded and object b is instantiated. [that's
        why you see execution of A's constructor before B's while creating object of B.]
        */

        System.out.println(a.a);//0
        System.out.println(a.b);//5
        a.setAB();
        System.out.println(a.a);//100
        System.out.println(a.b);//200
        System.out.println(b.a);//8
        System.out.println(b.b);//7
        System.out.println(b.c);//0
        b.showVars();//99 7 5 0

			/*

			System.out.println(b.super.a);
			The above line will not compile because you cannot use super
			(and this keyword as well)in a static context (inside the main method).

			*/

			/*
			 if you use super() or this() in constructor of child class then it
			 must be the first statement inside the constructor
			 */


			/*
			 ACCESS MODIFIERS

			 public : anyone can access this member
			 protected : anyone in same package and only child class members
			 			 of other package can access this member
			 default : anyone in same package can access this member and no one else
			 private : only same class members can access this member

			 Visibility Increase Order:
			 public > protected > default > private

			 UML - language : pictorial representation of a class
			 acc. to UML, public(+), protected(#), default(~), private(-)
			 */

			/*
			 be wary of static variables, instance variables (child class own),
			 inherited variables (purely from super class), overridden variables (from super class
			 but overridden by instance variables with same name) and local variables

			 similarly, static methods, instance methods, inherited methods, overridden methods
			 */


			/*

			 upcasting: [for dynamic method dispatch]

			 superClass supObject = new subClass(); //class subClass extends superClass


			 downcasting: [for accessing non-inherited methods of subclass]

			 superClass supObject = new subClass();
			 ((subClass)supObject).specializedMethod(); /* typecasting superclass object
			 type to subclass type to access non-inherited methods

			 */



    }


}

class A{
    int a,b=5;

    A(){
        System.out.println("A");
    }

    A(int a){
        this.a=a;
        System.out.println("A "+a);
    }

    void setAB( ) {
        a=100;
        b=200;
    }
}

class B extends A{


    int c;
    /*
     int a=99;
     this a overrides a variable from class A
     just like methods override and you CAN
     use super keyword to access class A's a present
     in class B instance

     similarly, int b;
     this makes b value 0 until it is initialized

     */
    int b=7;

    B(){
        super(8);//this must be the first stmt

		 /*
		  * constructor chaining: BY DEFAULT every
		  child class constructor executes super() stmt
		  as its first line [so, every class constructor calls
		  constructor of Object class]

		  if the above super stmt is not there then
		  A() constructor is invoked because by default
		  the first line of child class constructor is
		  super() without any arguments

		  if super() stmt is given explicitly then given
		  stmt is executed if not default super() without
		  any arguments would be executed
		  */

		 /*
		EVERY CHILD CLASS HAS IT'S OWN VARIABLES AND METHODS (which are accessed using 'this' keyword)
		AND ALSO HAS IT'S PARENT CLASS' VARIABLES AND METHODS (which are accessed using 'super' keyword)
		*/


        System.out.println("B");
    }

    void showVars() {
        int b=99;//local
        System.out.println(b);//99
        System.out.println(this.b);//7
        System.out.println(super.b);//5


    }
}


/*
 class Temp2 {
    Temp2(){
        System.out.println("Im Temp2");
    }
}

class Temp5 extends Temp2{
    //before non static blocks super() keyword in
	//constructor is executed. After that content
	//of non static block is moved to constructor
	//and executed after super() and before any other
	//content in constructor

	{
        System.out.println("Im Temp5 block");
    }
    Temp5(){
        System.out.println("im temp 5 cons");
    }
}

public class Temp3{
    public static void main(String []args){
        Temp5 t = new Temp5();
    }
}

output:
Im Temp2
Im Temp5 block
im temp 5 cons
 */


class X{
    public void sayHi() {
        System.out.println("Hi");
    }

    A doSomething() {
        return new A();
    }
}


class Y extends X{

	 /*
	 void sayHi() {
        error because visibility of sayHi() is reduced public to default
	    visibility of a overridden method can increase but not reduce
	 System.out.println("Hi Buddy");
	}
	*/


	 /*
	public int sayHi(){

	this doesn't override super class method generates error that its
	return type is not same as its counterpart to override not only
	names return types must also be same.

	return types can be different only if there is a is-a relationship between
	those types

		return 10;
	}


	*/

    protected B doSomething() {
        /*
        > return types has a is-a relationship: A is-a parent of B
        so overriding is done without any error.
        > visibility is increased here
        > if you swap return types of both methods then it throws error
        first type must be parent and overriding method type must be child
         */

        return new B();
    }

    public void sayHi(int a){
        /*
        this has no error and but doesn't override super class method
        so to override arguments must be same and return types also with
        one exception for return types
         */

        System.out.println("Hi "+a);
    }

    /*
    static methods participate in inheritance but they can't be overridden by subclass
    static methods of super class are completely hidden by those in subclass
     */

    /*
     Method Overriding Vs Method Hiding
        If a subclass defines a static method with the same signature
        as a static method in the superclass, then the method in the
        subclass hides the one in the superclass. This mechanism happens
        because the static method is resolved at the compile time. Static
        method bind during the compile time using the type of reference
        not a type of object.
    */

}

