public class C07KeywordFinal {

    /*
     final keyword has 3 uses:
        1. making primitive variables as constants
        2. making class un-inheritable
        3. making method un-overridable
        4. making reference variables to refer to only one object and cannot be
     reassigned to any other object but contents of that object can be modified
     */

    int a = 1;

    final int b = 1;

    /*
     now you cannot change value of b
     b is always 1 from now on and cannot re-assign
     */


    class SuperC{
        int a=1;
        int c;
    }

    class SubC extends SuperC{
        int b=2;
    }

    {
        System.out.println("The value of final variable b is "+b);
        //System.out.println(b++);CTE

        final SuperC superc = new SuperC();
        SuperC superc2 = new SuperC();
        SubC subc = new SubC();
        //superc = subc; error, it cannot be reassigned but you can modify its contents
        //superc = superc2; error, it cannot be reassigned as told
    }

}
