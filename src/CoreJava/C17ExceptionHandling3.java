package CoreJava;

public class C17ExceptionHandling3 {

    /*
> Custom Exceptions / User-defined Exceptions

class ATM{
	 private int accountNum = 1111111;
	 private int password = 2222222;
	 private int tempAccNum;
	 private int tempPass;

	 public void input(){
	 	 Scanner scan = new Scanner(System.in);
	 	 System.out.println("Enter Account Number :");
	 	 tempAccNum = scan.nextInt();
	 	 System.out.println("Enter Password :");
	 	 tempPass = scan.nextInt();
	 }

	 public void verify() throws InvalidUserException{
	 	if(accountNum == tempAccNum && password == tempPass){
	 		System.out.println("You have entered successfully");
	 	}
	 	else{
	 		InvalidUserException objIUE = new InvalidUserException("Invalid Credentials");
	 		System.out.println("Invalid Credentials");
	 		throw objIUE; // throw new InvalidUserException("Invalid Credentials");
	 	}
	 }
}

class InvalidUserException extends RuntimeException{
	InvalidUserException(String str){
		super(str);//=> RuntimeException(str);
  		// through constructor chaining value in str propagates to Throwable class
		//then one can access it from Throwable class using getMessage() and other methods available.
	}
}

class Bank{
	public void initiateATM(){
		ATM objATM = new ATM();
		objATM.input();
		try(){
			objATM.verify();
		}
		catch(InvalidUserException e){
			e.getMessage();
			objATM.input();
			try(){
				objATM.verify();
			}
			catch(InvalidUserException e){
				e.getMessage();
				objATM.input();
				try(){
					objATM.verify();
				}
				catch(InvalidUserException e){
					e.getMessage();
					System.out.println("You have entered incorrect password for three times.");
					System.out.println("Your card is blocked for next 24 hours");
					System.exit(0);
				}
			}
		}
	}
}


*/


/*

class UnderAgeException extends Exception{
	UnderAgeException(String msg){
		super(msg);//=>Exception(msg);=>Throwable(msg);
	}
}

class OverAgeException extends Exception{

	OverAgeException(String msg){
		super(msg);//=>Exception(msg);=>Throwable(msg);
	}
}

class LApp{
   private int age;

   public void input(){
	   Scanner scan=new Scanner(System.in);
	   System.out.println("Dear kindly enter your age to check eligbility");
	   age =scan.nextInt();
   }
   public void verify() throws OverAgeException, UnderAgeException{
	   if(age>=18 && age<=60){
		   System.out.println("You're eligible");
	   }
	   else if(age<18){
		   throw new UnderAgeException("Dude! Calm down take it slow kid");
	   }
	   else if(age >60){
		   throw new OverAgeException("Your time is near be carefull");
	   }
   }

}

class RTO
{
	void initiate()
	{
		LApp la=new LApp();
		try{
			la.input();
			la.verify();
		}
		catch(UnderAgeException a){
			System.out.println(a.getMessage());
			try
			{
				la.input();
			    la.verify();

			}
			catch(UnderAgeException b)
			{
				System.out.println(a.getMessage());
				System.out.println("Seems suspicious");
				System.exit(0);
			}
			catch(OverAgeException c)
			{
				System.out.println(a.getMessage());
				System.out.println("Seems suspicious");
				System.exit(0);
			}
		}
		catch(OverAgeException oae)
		{
			System.out.println(oae.getMessage());
			try
			{
				la.input();
			    la.verify();

			}
			catch(UnderAgeException b)
			{
				System.out.println("Seems suspicious");
				System.exit(0);
			}
			catch(OverAgeException c)
			{
				System.out.println("Seems suspicious");
				System.exit(0);
			}
		}
	}
}

*/


/*
> Try with Resources

Exception handling:
1. try catch and finally
2. throws(best suited for checkedException)
3. throw(best sutied for uncheckedException and customException)

Syntax
-------------------

try{
//risky code
}catch(XXXXX e){
//handling code
}finally{
//resource releasing code
}

In realtime application, we use many resources where all the resource should be
closed inside finally block.

resource => In File operations we use
			FileReader,FileWriter,BufferedReader,BufferedWriter
			In JDBC Operations we use
			Connection,Statement,PreapredStatement,CallableStatement,....

Realtime coding
-----------------------

//declaration of resources
try{
//risky code
use the resource
}catch(XXXXX e){
//handling code
}finally{
//resource releasing code
}

JDK 1.6 Version for developers
----------------------------

eg: BufferedReader br=null;
FileReader fr =null;
try{
fr = new FileReader("sample.txt");
br = new BuffereReader();
}catch(IOException e){
e.printStackTrace();
}finally{
if(br!=null)
br.close();
if(fr!=null)
fr.close();

}

boilerplate -> the code which is repeated in multiple modules of project with no
change or with small change.
whenever boiler plate code comes into picture, we always try
to avoid it by using

	a. using JDK software higher version(jdk1.0,jdk1.2,...... jdk18)
	b. using 3rd party API's

This is not good, because as the number of resources increase you have
to release them in finally which tedious.


In JDK 1.7 version they made few enhancement in the Excpetion handling area
----------------------------------------

1. try with resource
2. try with multicatch block


eg: without using try with resource
	-------------------------------

		BufferedReader br=null;
		FileReader fr =null;
		try{
			fr = new FileReader("sample.txt");
			br = new BuffereReader();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br!=null)
			br.close();
			if(fr!=null)
			fr.close();
		}

eg: try with resource
	--------------------

	try(BufferedReader br= new BufferedReader(new FileReader("sample.txt"))){
		//use the resource
	}catch(IOException e){
		e.printStatckTrace();
	}

	variables which are declared as a part of try with resources by default
	compiler will make them as "final"

	try(BufferedReader br= new BufferedReader(new FileReader("dhoni.txt"))){
		br = new BufferReader(new FileReader("kohli.txt"));//compile time error
		//br is "final" by default
	}catch(IOException e){
		e.printStatckTrace();
	}

Advantage of try with Resource
------------------------------

1. The main advantage of try with resource is the resources which are a part of
try block gets close automatically.

once the control comes of out try block automatically that resource will be
closed.

while try block is getting executed

a. exception occured and handled
b. exception occured and not handled

In both these cases also jvm will close the resource automatically, if we
use resource with "try with resource".


2. Using try with resource increases readabilty and reduces redundant code in our
application.


Conclusions
----------------

1. we can declare any no of resources ,but all the resources should be separated
with ; symbol.

try(R1;R2;R3; ........){
	///////////////////
	///////////////////
}catch(XXXXX e){

}

2. From JDK1.7 for Resource Releasing logic Requirement specification they had
come with an interface called "AutoCloseable" which is added in "java.lang" package.

interface AutoCloseable{
	public abstract void close() throws Exception;

}

public class BufferedReader implements AutoCloseable{

	@Override
	public void close(){
		//logic of closing.
	}
}

try(BufferedReader br=new BufferedReader(new FileReader("sample.txt"))){
	//logic of using br
}//after completion of try JVM calls close method by default

catch(IOException e){
	//handling logic
}

Note: try(String name = new String("sachin")){
		//using name object
	  } catch(Exception e){}

	  output: Compile Time Error

If you have to use a resource in try with resource then the resource must implement AutoCloseable interface
String class does not implement AutoCloseable

All java.io classes and java.sql classes has implemented AutoCloseable interface.

3. All resources reference variable are been made as final automatically when they
are used, so we can't re-assign the reference of the Resource Variable.

CompileTime Error
-----------------

try(BufferedReader br=new BufferedReader(new FileReader("sachin.txt"))){
br=new BufferedReader(new FileReader("kohli.txt")));

}catch(IOException e){}

4. Before JDK1.6

	try{

	}catch(XXXX e){

	}finally{

	}

	After JDK1.7, do we need finally block ?
	Ans. No, finally block becomes dummy if we use "try with Resource".

5. JDK1.6V

	try{

	}finally{

	}

	a. If exception does not occur => normal termination/smoothfull termination
	still finally executes.
	b. If exception occurs => abnormal termination still finally executes.

	JDK1.7
	try(R){

	}

	It is possible to write only try also from JDK1.7 version ,but that try
	should be associated with Resource.

*/

}
