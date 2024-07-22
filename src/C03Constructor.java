public class C03Constructor {

    /*
	 If you didn't provide ANY constructor in for a class then JVM
	 by would call the default parameterless constructor.

	 If you provide even at least one constructor then, JVM will not provide
	 any constructor. So, you must call one of the constructors you gave for
	 the class while creating object for it.
	 */

    int data1;
    int data2;
    char cdata3;

    //constructor chaining
    //this() must be the first stmt
    //https://www.geeksforgeeks.org/constructor-chaining-java-examples/#


    C03Constructor(int data1){
        //this(data1, 88); constructor chaining
        this.data1=data1;

    }
    C03Constructor(int data1, int data2){
        this.data1=data1;
        this.data2=data2;
    }
    C03Constructor(char cdata3){
        this.cdata3 = cdata3;
    }

	/*
	 While creating an object for this class if you
	 call parameterless constructor then, you will
	 encounter CTE.

	 C03Constructor C03Obj = new C03Constructor();
	 //CTE: constructor undefined error


	 //Anyone of the following would only be fine or else above CTE
	 Constructor constructorObj=new Constructor(8);
	 Constructor constructorObj=new Constructor(9,0);
	 Constructor constructorObj=new Constructor('K');
	 */

}
