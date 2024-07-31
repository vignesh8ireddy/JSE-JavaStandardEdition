import java.util.Scanner;
import java.util.InputMismatchException;

/*
 1. Compile-Time error : Syntax oriented/ faulty usage of the language
 	These errors can be resolved easily

 2. Run-Time error : [when application is running] Due to faulty logic like array index out of bound,
 						StackOverFlow error, et cetera;
       They represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory, memory leaks,
       stack overflow errors, library incompatibility, infinite recursion, etc.
       Run-Time errors are usually beyond the control of the programmer, and we should not try to handle errors.

 3. Exception : It is also a run-time error but not caused not because of faulty logic
 				but because of faulty input or unexpected technical issue with memory or anything
 		It is an unexpected event, which occurs during the execution of a program, i.e. at run time, that
   		disrupts the normal flow of the program’s instructions. Exceptions can be caught and handled by the program.

		Major reasons why an exception Occurs
		* Invalid user input
		* Device failure
		* Loss of network connection
		* Physical limitations (out-of-disk memory)
		* Code errors
		* Opening an unavailable file

     			Exceptions are of two types:

 				1. Checked Exceptions - exceptions which are predicted in compile time itself

 				2. Unchecked Exceptions - Runtime exceptions (these exceptions cannot be
 				predicted at compile time)

 Run-time error(including exceptions) always terminates the application abruptly


 Checked exceptions occur while using multi-threading, file handling concepts. During compiling itself exceptions are
 predicted and forces you to handle it before application has ran.
 Note: During Compile-time exceptions will not occur but they get predicted during compile-time itself.

 Compile-time exceptions are called "checked exceptions"
 Run-time exceptions are called "unchecked exceptions"

 */

/*
 Whenever an exception has occurred then the method in which the exception occurred creates an Exception
 class' object and gives it to the JVM. JVM then checks whether that exception is handled or not by the user.
 If not handled then the exception is given to default exception handler and then the application is terminated
 abruptly.
 */


/*

 Handling Exceptions:

 -----------------------------------
 try [allowed]
 catch [not allowed]
 try + (multiple)catch [allowed]
 try + finally [allowed]
 finally [not allowed]
 -----------------------------------


     try{
     //block where expected exception may occurs
      the lines after the line which generated exception are not executed, directly control
      goes to the catch block. the lines after the catch block are also executed.
     }

     catch{
     //what you gonna do if the exception occurs
      i.e how you gonna handle that exception
     }

there cannot be executable code between any two consecutive catch blocks.
But there can be executable code between last catch block and finally block.

 every try block must have at least one catch block to stop abrupt termination by catching the exception.

 finally{
 ---------------//mostly used to release resources
 ---------------
 //this is executed whether catch block handled exception or not, before termination normally or abnormally
 }
 // the lines after finally block are executed only if there is no exception occurred in corresponding try block or
  the exception is handled by one of the catch blocks

 after one catch block is executed remaining catch blocks are skipped and finally block is executed

 if exception occurred and not handled by any of the catch blocks then only finally block is executed leaving statements
 after the finally block



 */





/*

We can write statements like try, try with a catch block, try with multiple catch blocks, try with finally block and try with
catch and finally blocks.


*/


public class C15ExceptionHandling {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /*
		try {
			int a = 5;
			int b = 0;
			System.out.println(a/b);
		}

		catch(Exception e) {
			System.out.println(e);//java.lang.ArithmeticException: / by zero
		}//you can have multiple catch blocks for one try block
		*/

		/*
		try {
			System.out.println("Enter size of array");
			int size = scan.nextInt();
			int []arr = new int[size];
			System.out.println("Enter element to be entered:");
			int ele = scan.nextInt();// scope for java.util.InputMismatchException
			System.out.println("Enter position at which "+ele+" has to be inserted");
			int pos = scan.nextInt();////scope for java.lang.ArrayIndexOutOfBoundsException
			arr[pos] = ele;
			System.out.println(ele+" inserted at "+pos);
		}

		catch(Exception e) {
			System.out.println(e);//java.lang.ArithmeticException: / by zero
		}
		System.out.println("Thank you for using the appliction.");


		this is not a good a way of handling exceptions. Write catch block for each and every exception instead of
		handling all exceptions using Exception class (super class of all exceptions)
		*/


        try {
            System.out.println("Enter size of array");
            int size = scan.nextInt();
            int []arr = new int[size];
            System.out.println("Enter element to be entered:");
            int ele = scan.nextInt();// scope for java.util.InputMismatchException
            System.out.println("Enter position at which "+ele+" has to be inserted");
            int pos = scan.nextInt();////scope for java.lang.ArrayIndexOutOfBoundsException
            arr[pos] = ele;
            System.out.println(ele+" inserted at "+pos);
        }

        //After an exception is caught by one catch block no other catch blocks are executed.
        catch(ArithmeticException e) {
            System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch(NegativeArraySizeException e) {
            System.out.println(e);
        }
        catch(InputMismatchException e) {
            //you have to import util package for this exception, unlike others which are in default package lang.
            System.out.println(e);
        }
        catch(Exception e) {//this block for some un-anticipated exceptions

		/*
		   this block must be the last one to avoid "unreachable catch block" error for catch blocks present after this.
			Unreachable catch block. It is already handled by the catch block for Exception
		*/
            System.out.println(e);
        }

        //writing catch blocks prevent from abnormal termination of application
        System.out.println("Thank you for using the application.");

		/*
		 If an exception has occurred outside of a try block then there are no catch blocks to handle it. So, it
		 leads to an abnormal termination of application.

		 Only when an exception is caught by a catch block then application is terminated normally by executing
		 statements after the catch block
		 */


		/*
		 This is also not a good practice of handling exceptions. Better write try block for each and every expected
  		 scenario and catch them using multiple catch blocks.
		*/
    }

	/*
	 * finally vs return => finally always dominates return

	 try {
	 	System.out.println("Inside try");
	 	return 15;//here, control directly goes to finally block and executes those statements and then returns 15
	 	//anything here is unreachable
	 }
	 catch(Exception e) {
	 	System.out.println("Inside catch");
	 }
	 finally() {
	 	System.out.println("Inside finally");
	 	//remember? always executed right before the method leaves runtime stack
	 }

	 output: (Assume no exception)

	 Inside try
	 Inside finally


	 * finally vs System.exit(0) => System.exit(0) dominates finally

	 try {
	 	System.out.println("Inside try");
	 	System.exit(0); //this terminates the JVM itself
	 }
	 finally() {
	 	System.out.println("Inside finally");
	 }

	 output: (Assume no exception)

	 Inside try

	---------------------------------------------
	System.exit(0) : successful termination of JVM
	System.exit(1) : unsuccessful termination of JVM
	System.exit(-1) : unsuccessful termination of JVM with an exception

	 */


}
