public class C06StaticVariables {
    /*
	 > Static members are created only once, at the time of class loading
	 in Heap and they global and common to all the instances of the class

	 > Instance variables are created everytime an instance is created during
	 runtime in Heap and they are local to the corresponding instance

	 > Use static variables whenever you want global variables that can be
	 accessed and modified by any instance of the class
	 */

    static int a,b,c;
    int x,y,z;

    {//normal block

		/*
		 > This block is always executed before constructor
		 i.e Everytime an instance is created this block is executed
		 before the constructor is executed

		 > If you wanna do something everytime while you are creating an object
		 before constructor, this is the way
		 */

        a++;
        b++;
        c++;
        x++;
        y++;
        z++;


    }

    void setSVariables(int a,int b, int c) {//setStaticVariables

        //this keyword cannot be used for static members
        //so name collisions can be resolved as follows

        C06StaticVariables.a=a;
        C06StaticVariables.b=b;
        C06StaticVariables.c=c;

    }

    void setIVariables(int x, int y, int z) {//setInstanceVariables

        this.x=x;
        this.y=y;
        this.z=z;

    }

    void displaySVariables() {

        //non static method to access static variables
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("c = "+c);
    }

    void displayIVariables() {

        //non static method to access instance variables
        System.out.println("x = "+x);
        System.out.println("y = "+y);
        System.out.println("z = "+z);
    }

    public static void main(String []args) {

        C06StaticVariables SV1=new C06StaticVariables();
        System.out.println("After creating an object SV1 and "
                + "before assigning static and instance variables");
        SV1.displaySVariables();// 0+1 0+1 0+1
        SV1.displayIVariables();// 0+1 0+1 0+1

        SV1.setSVariables(100, 200, 300);
        SV1.setIVariables(10, 20, 30);

        System.out.println("After initialising static and "
                + "instance variables using SV1");
        SV1.displaySVariables();// 100 200 300
        SV1.displayIVariables();// 10 20 30

        C06StaticVariables SV2=new C06StaticVariables();

        System.out.println("After creating another object SV2 and "
                + "accessing static and instance variables using SV2");
        SV2.displaySVariables();// 100+1 200+1 300+1
        SV2.displayIVariables();// 0+1 0+1 0+1

        SV2.a=1000;//generates warning : The static field StaticVariables.a should be accessed in a static way
        //Above style of access static variables is not good

        C06StaticVariables.b=2000;//this is good way to access to static members
        C06StaticVariables.c=3000;

        SV2.setIVariables(70, 80, 90);

        SV2.displaySVariables();// 1000 2000 3000
        SV2.displayIVariables();// 70 80 90

        SV1.displaySVariables();// 1000 2000 3000
        SV1.displayIVariables();// 10 20 30
    }
}

/*
can static blocks call:
	static variables ✔ 
	static methods ✔ 
	non static variables ❌ 
	non static methods ❌ 
but you can create an instance for the class and call non static variables and non static methods 
same goes with static methods calling non static members.(That's what you do with main method in java)
*/
