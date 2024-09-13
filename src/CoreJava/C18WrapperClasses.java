package CoreJava;

public class C18WrapperClasses {

    /*

JDK1.5 features
------------------

1.Wrapper classes
2.Var-Args

Wrapper class
------------------

1. Wrapper classes are used to wrap primitive data types into object data types so that we can handle primitive types like objects
2. Wrapper classes are used to define several utility functions which are required for primitive types.
3. Wrapper classes are a part of "java.lang" package.

primitive data types
---------------------
1. byte,short,int,long
2. float,double
3. char
4. boolean

For every primitive type we have equivalent Wrapper class as shown below
byte -> Byte class; has two constructors/ one takes byte and other String
short -> Short class; has two constructors/ one takes short and other String
int -> Integer class; has two constructors/ one takes int and other String
long -> Long class; has two constructors/ one takes long and other String
float -> Float class; has three constructors/ one takes float, one double and other String
double-> Double class; has two constructors/ one double and other String
char -> Character class (has only 1 constructor that has char as argument)
boolean -> Boolean class (2 constructors, one with boolean, one with String argument is important))

All wrapper class objects are immutable just like objects of String class

In all wrapper classes toString() of Object class is overridden to return other content instead of reference hash value

class Object{
	public String toString(){
		// returns the reference(address/hashCodeValue) of the object
	}
	public boolean equals(Object o){
		//compares o and 'this' references
	}
}

public final class Integer extends Object{
	@Override
	public String toString(){
		//returns the data present in the Object
	}
}// printing reference variable of every Wrapper class gives its content rather than reference address value

Almost every Wrapper class contains 2 constructors of which

a. takes corresponding primitive type as the argument.
b. takes String type as the argument.

	eg#1.
		Integer i1 = new Integer(10);
		System.out.println(i1);//jvm calls i1.toString()
		Integer i2 = new Integer("10");
		System.out.println(i2);//jvm calls i1.toString()


	output:
		10
		10

	eg#2
		If the String input is not properly formatted, meaning if it is not representing any
		number then we will get an Exception called "NumberFormatException"
		Integer i2 = new Integer("ten");//NumberFormatException

		//Integer class constructor can take either int type or properly formatted string

	eg#3.
		Character class contains only constructor which can take only primitive
		argument of type char only.
		So, Character class constructor can take only char type as input.

		Character c1=new Character('a');
		System.out.println(c1);
		Character c1=new Character("a");//Compile Time Error.
		System.out.println(c1);
		Character c1=new Character(45);//Compile Time Error.
		System.out.println(c1);

	eg#4.
		Boolean b=new Boolean(true);
		System.out.println(b);//true
		Boolean b=new Boolean(false);
		System.out.println(b);//false
		Boolean b=new Boolean(True);//Compile Time Error
		Boolean b=new Boolean(False);//Compile Time Error

	Note: If we are passing String argument, then case is not important and content is
	important.
	if the content is case insensitive String of true then it is treated as
	true and in all other cases it is false.

	eg#5
		Boolean b1=new Boolean("false");
		System.out.println(b1);//false
		Boolean b2=new Boolean("False");
		System.out.println(b2);//false

	eg#6
		Boolean b1=new Boolean("true");
		System.out.println(b1);//true
		Boolean b2=new Boolean("True");
		System.out.println(b2);//true

	eg#7.
		Boolean b1=new Boolean("yes");
		System.out.println(b1);//false
		Boolean b2=new Boolean("no");
		System.out.println(b2);//false
		Boolean b1=new Boolean("tRuE");
		System.out.println(b1);//true
		Boolean b2=new Boolean("TrUe");
		System.out.println(b2);//true

Object class methods
-------------------------------

//use this command in command prompt to get all methods of Object class : javap java.lang.Object
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

> String toString()
	JVM will always call toString() when we try to print any reference variable.

	Reference variable can be
	a. inbuilt class
	b. user defined class

	eg#1.

	class Object{
		public String toString(){
			// returns the reference(address/hashCodeValue) of the object
		}
	}

	public final class String extends Object{
		@Override
		public String toString(){
			//returns the data present in the Object
		}
	}

	String name= new String("sachin");
	System.out.println(name);// jvm internally calls name.toString()

	eg#2.
	class Object{
		public String toString(){
			// returns the reference(address/hashCodeValue) of the object
		}
	}
	public class Student extends Object{
		String name;
		Student(String name){
			this.name =name;
		}
		public String toString(){
			// returns the reference(address/hashCodeValue) of the object
		}
	}
	Student student = new Student("sachin");
	System.out.println(student);//JVM calls student.toString()
	output: hashCode value of Student object

	eg#3.
	class Object{
		public String toString(){
			// returns the reference(address/hashCodeValue) of the object
		}
	}
	public class Student extends Object{
		String name;
		Student(String name){
			this.name =name;
		}
		@Override
		public String toString(){
			return this.name;
		}
	}
	Student student = new Student("sachin");
	System.out.println(student);//JVM calls student.toString()
	output: sachin

*/

/*

equals() method of Object class is also overriden in all Wrapper
classes to compare content instead of reference variables.

class C0020{
	public static void main(String []args){
		Integer int1 = new Integer(10); //using constructor to create Wrapper class instance
		Integer int2 = new Integer("10"); //using constructor to create Wrapper class instance
		System.out.println(int1.equals(int2));//return true
	}
}

*/

/*

Usage of Wrapper classes
------------------------

> Use utility methods (helper methods) present in the Wrapper classes.

	All utility methods are static.

	1. valueOf()

		method signature: public static wrapper valueOf(primitive data)
						  public static wrapper valueOf(String data)

		It is used to create Wrapper class instance from properly formatted Strings
		and primitive data types.

		Integer int3 = Integer.valueOf(10); //using utility function to create Wrapper class instance
		Integer int4 = Integer.valueOf("10"); //using utility function to create Wrapper class instance
		Double d1 = Double.valueOf(10.5);
		Boolean B1 = Boolean.valueOf("Math");
		Character char1 = Character.valueOf('M');
		//System.out.println(int3/int4/d1/B1/char1);		10/10.5/false/'M'

		Character char2 = Character.valueOf("m");//Compile Time Error; only char value
		//String to wrapper class using valueOf is not possible

		It is an alternative to using constructor to create Wrapper class instance and
		using valueOf() for creating Wrapper class instances is best way rather than
		using constructor because the latter way is deprecated

	2. XXXXValue() // XXXX = any primitive datatype (byte,short,int,long,float,double,char,boolean)

		method signature: public static XXXX XXXXValue();

		It is used to create primitive data types from wrapper class types

		Integer intTemp = Integer.valueOf(130);
		byte bt1 = intTemp.byteValue();
		short sh1 = intTemp.shortValue();
		System.out.println(bt1);//-126 (out of range: jvm does -128+(130-127)-1)
		System.out.println(sh1);//130
		System.out.println(intTemp.intValue());//130
		System.out.println(intTemp.longValue());//130
		System.out.println(intTemp.floatValue());//130.0
		System.out.println(intTemp.doubleValue());//130.0
		System.out.println(intTemp.charValue());// Compile Time Error: charValue() not defined for Integer
		System.out.println(intTemp.booleanValue());// Compile Time Error: boolean() not defined for Integer

		Every Numeric type wrapper class (Byte, Short, Integer, Long, Float, Double) has
		these 6 methods : byteValue(), shortValue(), intValue(), longValue(), floatValue()
		and doubleValue()

		charValue() and booleanValue() methods are not defined in Numeric type wrapper classes.

		Character charTemp = Character.valueOf('M');
		char ch1 = charTemp.charValue();
		System.out.println(ch1);//'M'

		Character wrapper class has only charValue() method

		Boolean boolTemp = Boolean.valueOf("math");
		System.out.println(boolTemp.booleanValue());//false

		Boolean wrapper class has only booleanValue method

	3. parseXXXX() // XXXX = any primitive datatype (byte,short,int,long,float,double,char,boolean)

		method signature: public static XXXX ParseXXXX(String data);

		Every wrapper class except Character class has parseXXXX() method to convert String to
		XXXX primitive type

		int i1 = Integer.parseInt("10");
		System.out.println(i1);//10

		boolean b1 = Boolean.parseBoolean("TrUE");
		System.out.println(b1);//true

		short s1 = Short.parseShort("Ten");
		System.out.println(s1);//Runtime - Exception: NumberFormatException (It is unchecked exception)

	4. toString()

		method signature: public static String toString(primitive data) corresponding primitive type to String
						  public static String toString()//Wrapper class content to String

		Used to convert wrapper object and primitive data to String type

		while printing any reference variable by default JVM will call toString() method.

		In-case of Wrapper class references toString() method is overridden one.
		which gives content in string format instead of reference address/hash value

		Integer intTemp = Integer.valueOf("10");
		System.out.println(intTemp);//10 (which is in string format) (toString method is called by JVM);
		System.out.println(intTemp.toString());//this is same as above .toString() is redundant

		String s1 = Integer.toString(10);//creating strings using wrapper class utility function toString
		String s2 = Boolean.toString(true);
		String s3 = Character.toString('m');

		System.out.println(s1);//10 (in string format)
		System.out.println(s2);//true (in string format)
		System.out.println(s3);//m (in string format)
*/


/*

AutoBoxing and AutoUnBoxing(JDK1.5V)
------------------------------------

valueOf() -> To convert String/primitive to Wrapper Object
xxxxValue() -> To convert Wrapper to primitive type.

	Integer i = 10;
	|
	|compiler will make the following change
	|
	Integer i = Integer.valueOf(10);

Automatic conversion of primitive type to wrapper type done by the compiler is
called "AutoBoxing".

	Integer i1= new Integer(10);
	int i2 = i1;
	|
	|Compiler will do the following change
	|
	int i2= i1.intValue();

Automatic conversion of wrapper type to primitive type done by the compiler is
called "AutoUnBoxing".

Autoboxing and UnBoxing
-----------------------

	eg#1.
	class TestApp{
		static Integer I=10;//AutoBoxing(valueOf())
		public static void main(String[] args){
			int i=I;//AutoUnBoxing(intValue())
			System.out.println(i);//10
		}
	}

	eg#2.
	class TestApp{
		static Integer I=0;//AutoBoxing(valueOf())
		public static void main(String[] args){
			int i=I;//AutoUnBoxing(intValue())
			System.out.println(i);//0
		}
	}

	eg#3.
	class TestApp{
		static Integer I=null;//AutoBoxing(valueOf())
		public static void main(String[] args){
			int i=I;//AutoUnBoxing(intValue())
			System.out.println(i);
		}
	}

	a. null
	b. 0
	c. CE
	d. NumberFormatException
	e. NullPointerException
	f. None of the above

	Object is not ready and you are trying to invoke a method over it.
	This results in NullPointerException Output


	Note: Immutable Object -> String, All wrapper classes
	(if we try to make a change, then with the change new object will be created)

	Integer x=10;
	Integer y=x;
	x++;
	System.out.println(x);//11
	System.out.println(y);//10
	System.out.println(x==y);//false

Snippet(s)
---------

Integer x=new Integer(10);//new object
Integer y=new Integer(10);//new object
System.out.println(x==y);//false

Integer x=new Integer(10);
Integer y=10;
System.out.println(x==y);//false

Integer x=new Integer(10);
Integer y=x;
System.out.println(x==y);//true

Integer x=10;//Integer.valueOf(10);
Integer y=10;//Integer.valueOf(10);
System.out.println(x==y);//true

//A byte is allocated to integer constants, so it has -128 to 127 integer literals
//x and y both are pointing to memory location of 10 literal in byte

Integer x=100;//Integer.valueOf(100);
Integer y=100;//Integer.valueOf(100);
System.out.println(x==y);//true
//x and y both are pointing to memory location of 100 literal available in byte

Integer x=1000;//new object
Integer y=1000;//new object
System.out.println(x==y);//false
//1000 literal is not available in byte.

Note: for byte,short,int,long,float,double the buffer concept which internally jvm
maintains has "byte range only".
	character -> 0 to 127
	Boolean -> always(true or false)

*/


/*

Whenever you use new keyword memory is allocated at heap memory.

*/

}
