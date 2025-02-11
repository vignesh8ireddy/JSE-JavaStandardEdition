package Java8Features;

public class Main {
    public static void main(String[] args) {
/*
        Addition<Integer> addImpl = (Integer a,Integer b) -> {
            return a+b;
        };
*/
        Addition<Integer> addImpl = (a, b) -> {return a+b;};
//      Addition<Integer> addImpl = (a, b) -> a+b; // this is same as above
        /*
        For single statement definition, you don't have to use block i.e {}
        For single statement return definition, you don't have to use block and return key word also
         */
        System.out.println(addImpl);// prints lambda function as inner class: Java8Features.Main$$Lambda$21/0x0000026e450023f8@214c265e
        System.out.println(addImpl.add(15,20));

        Wish wishImpl = strObj -> "Hi "+strObj; //for one parameter, using paranthesis is optional
        System.out.println(wishImpl.Hi("Vignesh"));

    }
}
