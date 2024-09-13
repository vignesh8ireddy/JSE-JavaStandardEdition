package CoreJava;

public class C02ClassBasics {

    //instance variables: anyone in class can access
    int i;
    double j=23.0;

    {
        System.out.println("Normal Block A");
    }

    static {
        System.out.println("Static Block M");
    }

    {
        System.out.println("Normal Block Q");
    }

    C02ClassBasics(){
        i=44;
        System.out.println("Constructor");
    }

    {
        System.out.println("Normal Block X");
    }

    static {
        System.out.println("Static Block U");
    }

    /*

    Four Basic types of class members:
    1. Data Variables: Declaration and Definition(=Declaration+initialisation)
    2. Blocks
    3. Constructors
    4. Methods

    > Within it's body, a class can have only above four.
    > It's not possible to have executable code within class body:
        System.out.println("Class body"); // Error, executable code
        i=32; //Error, executable code

    > Executable code shall be present only inside block, constructor or method


     */

    void showVariables(){
        //local variable: can access only in this method
        int k;

        /*
        If local variables are tried to access without initialising, there would
        be a compile-time error.
        But if instance variables are tried to access without initialising, there
        wouldn't be any error but gives garbage value (zero mostly).

        > instance variables are stored in heap area
        > local variables are stored in stack area
         */

        System.out.println("i="+i+
                "\nj="+j);
        //System.out.println(k); CTE: variable k might not have been initialized

    }

     /*
    1. After compilation of code, java class is loaded from .class file
    2. Static members are assigned memory during compile-time itself.
    3. When class is loaded, first of all, static blocks are executed in the order.
    4. Then, during it's Object creation, memory would be assigned to non-static members.
    5. After that, all the normal blocks would be executed in the order
    6. Then, constructor would be executed

    A class will be loaded right before creation of its object.
    If no object is created for a class then, the class is not loaded.
     */




}
