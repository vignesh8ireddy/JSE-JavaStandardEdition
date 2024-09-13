package CoreJava;

import java.util.Scanner;

/*

 If a method A generated an exception and doesn't handle it, then JVM will not call default exception handler immediately.
 It checks whether the method that called A handles the exception or not, if not then it checks the method that called the
 method which called A handled exception or not and so forth until the RUNTIME STACK has no methods left.
 If no method in the Runtime Stack handled the exception then JVM will call the default exception handler.

 */

class Theta{
    Scanner scan = new Scanner(System.in);

    public int Div() {
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = a/b;
		/*
		 If a divided by zero exception occurs here, as we did not provide any exception handlers
		 JVM checks the method calling Div() i.e display() handled the exception or not
		 If handled then application is terminated normally, else it checks the method which called
		 display i.e main() handled the exception or not if not handled then the program will be
		 terminated abnormally
		 */
        return c;
    }

    public int Div2() {
        return 12/0;
    }

    public int Div3() throws ArithmeticException{
        return 12/0;
    }
}

class Zeta{

    public void display() {
        try {
            Theta TObj = new Theta();
            System.out.println(TObj.Div());
        }
        catch(ArithmeticException e) {
            System.out.println(e);
        }
        //instead of handling here you can handle the exception generated at Div() method in main() also
    }

    public void display2() throws ArithmeticException{//ducking the exception to main method
        Theta TObj = new Theta();
        System.out.println(TObj.Div2());
    }

    public void display3() throws ArithmeticException{
        try {
            Theta TObj = new Theta();
            System.out.println(TObj.Div3());
        }
        catch(ArithmeticException e) {//handles exception and re throws the exception
            System.out.println(e+"\nHandled thrown exception");
            System.out.println("and again throwing the handled exception");
            throw e;

            //re-throwing the exception after handling it. If this exception is not handled by higher
            //hierarchy methods then program is terminated abtruptly

            //anything after throw statement is unreachable code because it is just like return statement(except finally block)
            //finally block is executed just before the method is popped from runtime stack
            //only finally block is executed after throw statement


			/*
			 As you are re-throwing the exception you better inform the higher hierarchy about the exception
			 using throws keyword

			 Ducking : Ignoring an exception to higher hierarchy to handle it.

			 whether you are ducking or re-throwing an exception explicitly use throws keyword in method
			 signature to inform higher hierarchy about the exception
			 */

        }

        finally {// executed when the method is removed from runtime stack
            System.out.println("Thank you for using application");
        }

        //anything after throw statement is unreachable code because it is just like return statement(except finally block)
        //anything after throw statement is unreachable code because it is just like return statement(except finally block)
        //finally block is executed just before the method is popped from runtime stack
        //only finally block is executed after throw statement

    }

}

/*

 Whenever an exception has occurred :

 1. you can handle it using try and catch blocks
 2. you can duck it using throws keyword : this is not handling the exception just informing that an exception may occur,
 	this may lead to abtrupt termination of program if not handled in higher hierarchy
 3. you can re-throw it using try, catch, throw, throws, finally

 ducking an exception means you are ignoring the exception but delegating/informing that the exception may occur to the
 caller method so that he will handle it. If caller method did not handled the exception then program will terminate abnormally
 thows - used to delegate/inform an exception may occur to higher hierarchy methods

 re-throwing : throwing explicitly handled exception is called re-throwing
 this is a good practice of dealing with exceptions. Always handle the exceptions, re-throw it (and also inform about the exception)
 to the higher hierarchy in the runtime stack
 throw - used to re-throw the exception to higher hierarchy methods after handling it

 so whenever you use throw, better use throws in that method method signature to inform about the exception to higher hirarchy
 about the exception you are throwing


 whenever you are calling a method whose method signature has throws better write the calling part in try block and handle
 the exception using catch block


		//anything after throw statement is unreachable code because it is just like return statement(except finally block)
		//finally block is executed just before the method is popped from runtime stack
		//only finally block is executed after throw statement
 */



public class C16ExceptionHandling2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Zeta ZObj = new Zeta();
        //ZObj.display();


        try {
            ZObj.display2();
        }

        catch(ArithmeticException e) {
            System.out.println(e +"\nDucked Exception handled in main");
        }

		/*
		 you cannot have executable code between the catch block and the finally block.
		 In Java, the syntax for a try-catch-finally block is structured in a way that the finally block should
		 come after the catch block.

		 If you need to execute additional code between catching an exception and the finally block,
		 you would typically place that code inside the catch block.
		 The finally block is intended for code that must be executed regardless of whether an exception is thrown or not.
		 */

        finally {
            System.out.println("Thank you for using application");
        }



        try {
            ZObj.display3();
        }
        catch(ArithmeticException e) {
            System.out.println(e +"\nRe-thrown Exception handled in main");//so app terminates normally
        }

        finally {
            System.out.println("Thank you for using application");
        }
        //if re- thrown exception is not caught then app is suspended abtruptly.

    }



}




/*

 Methods to print Exception Information.

 The following three methods are used to get information about exceptions.
 These methods belong to Throwable class.

 1. getMessage() : prints the description of the exception
 		example - / by zero
 2. toString() : Prints the name and the description of the exception.
 		example - ArithmeticException: / by zero
 3. printStackTrace : Prints the name and the description of the exception along with the stack trace.



 If a parent class has all its child classes throwing only checked exceptions the such
 parent class is called fully checked exception class, similarly fully unchecked class.

 If a parent class has some of its child classes throwing checked exceptions and some
 unchecked exceptions then, such parent class is called partially checked exception class


 Object class is parent class of all classes in java.

 											  java.lang.Object
	      											|
     											    Throwable
		    										|
   											 Error,Exception

 Error class is fully unchecked exception class because all of its child classes throw only
 unchecked exceptions

 Exception class is a partially checked exception class because of its child classes
 RuntimeException class is fully unchecked exception class and IOException class,
 InterruptedException class and SQLException class are fully checked exception classes

 Similarly, throwable is also partially checked exception class because Error is
 fully unchecked exception class and Exception is partially checked exception class

 So if a class has one of its child classes partially checked exception class then
 the parent class is also partially checked exception class and so are the entire
 ancestor classes


 */


/*

> Handling checked exceptions

  In case of checked exceptions, exception will not occur during
  compile time, it is just checked(predicted) at compile time and forces you
  to handle them before the application has ran.

  void showCheckedException(){
  	PrintWriter pw = new PrintWriter("abc.txt");
  	pw.write("Hello, AB");

  }

  Output-

  error: FileNotFoundException; must be caught or declared to be thrown

  So in case of checked exceptions either handle them by catching using
  try catch blocks (recommended) or duck them using throws (not recommended)

  void showCheckedException(){
  	try{
  		PrintWriter pw = new PrintWriter("abc.txt");
  		pw.write("Hello, AB");
  	}
  	catch(FileNotFoundException e){
  		System.out.println(e);
  }

  Ducking the checked exception (this method of handling works but not recommended
  because may result in abnormal termination as you are ducking it)

  void showCheckedException() throws FileNotFoundException {

  	PrintWriter pw = new PrintWriter("abc.txt");
  	pw.write("Hello, AB");

  }
*/


/*

> throw keyword



creating and throwing an exception explicitly

	void createExceptionExplicitly(){
		throw new ArithmeticException("/ by zero");
		//any lines here are not going to execute
		//if there is anything here, a compile time error is going to generate
		//as you are creating exception explicitly
		System.out.println("zero");

		this code going to terminate abtruptly but before generates compile time error
	}

	void tempException(){
		int x = 16/0;
		System.out.println("zero");

		this code is going to terminate abtruptly directly with no compile time
		error before
	}

	* throw only works with the objects of Throwable class and its subclasses

	class Launch{
		public static void main(String[] args){
			throw new Launch();
			//error: incompatible types: Launch cannot be converted to Throwable
		}
	}

	class Launch extends RuntimeException{//Launch -> RuntimeException -> Exception -> Throwable
		public static void main(String[] args){
			throw new Launch();
			//Works fine now
		}

	}

*/


/*
> throws keyword

It is used in

1. method definition
2. constructor definition

to inform caller that the method is exception prone.

cannot used in class definition

*/

/*

Exception handling with method overriding:

Method overriding, when used to handle exceptions, is quite uncertain as the compiler cannot understand which definition to use, the superclass or subclass.
There are two important points to remember while handling exceptions using method overriding.

1. If the superclass method does not declare an exception, then the overriding subclass method cannot declare a checked exception,
but it can declare an unchecked exception.

2. If the superclass method declares an exception, then the overriding subclass method can declare the same exception, subclass exception
or no exception, but it cannot declare a parent exception thrown by the superclass method.

As the compiler monitors checked exceptions during compile time. An overriding subclass method can not throw a checked exception
when the overriding superclass method has no exceptions, because polymorphism is a concept of run-time and checked exceptions is a concept
of compile-time.

class DemoX{
	void Disp(){
		System.out.println("Parent class' overriden method");
	}
}

class DemoY extends DemoX{
	void Disp() throws ArithmeticException{
		//Here overriden method is not throwing any exception
		//So, overriding method can throw any unchecked exception or not throw any exception at all.
		//But, overriding method cannot throw any checked exception
		System.out.println("Child class' overriding method");
	}
}

-----------------------------------------------------------------------

class DemoX{
	void Disp() throws ArithmeticException{
		System.out.println("Parent class' overriden method");
	}
}

class DemoY extends DemoX{
	void Disp() throws ArrayIndexOutOfBoundsException{
		//Here overriden method is throwing unchecked exception
		//So, overriding method can throw any unchecked exception or not throw any exception at all.
		//But, overriding method cannot throw any checked exception
		System.out.println("Child class' overriding method");
	}
}


*/


/*

> Nested try catch blocks
> try catch finally combinatons
	* only try block possible? - No//// Maybe Yes | verify this
	* only catch block possible? - No
	* only finally block possible? - No
	* one try atleast one catch block? - Yes
	* one catch followed by corresponding try possible? - No
	* Multiple try and one catch possible? - No
	* one try and one finally - Yes
	* catch block with more than one exceptions - Yes
		catch(xxxxx | yyyyyy e){
			/////////////
		}

*/

//use throws for checked exceptions
//use throw for unchecked exception after catching it.