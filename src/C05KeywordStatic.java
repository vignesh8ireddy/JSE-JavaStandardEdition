public class C05KeywordStatic {

    /*
    > static Keyword is used to access members of class without creating object.
      so, static keyword is attached to only members of class (except constructor)
	    static variables: (possible)
	    static blocks   (possible)
	    static methods  (possible)
	    static constructor (meaningless and impossible)

  	> static when attached to a variable, a method or a block makes it the class variable, the class method
  	  and the class block.
  	  static variables/methods are accessed using ClassName.
      static blocks are executed when the class is loaded and memory is deallocated for the block
	 */

    static int x,y,z;
    /*
    > static variables are created and allocated memory(in heap) during compile-time itself
    > They aren't instance variables (=> accessed using classname not objectname)
    > Everyone can access them (and they are common for everyone)
     */


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

    C05KeywordStatic(){

        System.out.println("constructor");
        a=50;
        System.out.println("a = "+a);
    }

	/*
	 > static members can only access static members i.e static methods and static
	 blocks can access only static variables and call static methods but cannot
	 access non-static members because while static elements are getting executed
	 non-static members are not even got created.

	 But non-static members can access static members.
	 */

	/*

	 Before main() method its class is loaded
	 [class in which main() is present] and immediately after
	 that its static blocks and static variables are executed
	 then, main() method is called by JVM

	 */

	public static void main(String []args) {

		System.out.println("Main Method starts");
		display();
		System.out.println("An Object is created next line");
		C05KeywordStatic KS=new C05KeywordStatic();
		System.out.println("Main Method ends");

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


    /*
	class constructor can not be static, final and abstract;
	One of the important property of java constructor is that it can not be static.
 	We know static keyword belongs to a class rather than the object of a class.
  	A constructor is called when an object of a class is created, so no use of the static constructor.

 	Constructors are not inherited in java. Therefore, constructors are not subject to hiding or overriding.
  	When there is no chance of constructor overriding, there is no chance of modification also. When there is
   	no chance of modification, then no sense of restricting modification there.
	*/

}// refer: https://www.geeksforgeeks.org/class-loading-and-static-blocks-execution-using-static-modifier-in-java/
