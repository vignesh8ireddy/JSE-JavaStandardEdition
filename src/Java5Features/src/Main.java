import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static util.MathUtility.PI;
import static util.MathUtility.square;

public class Main {
    public static void main(String[] args) {

        // 1. Static Import

        /* without using static import
        System.out.println("Pi value is : "+MathUtility.PI);
        System.out.println("Square of 5 is : "+ MathUtility.square(5));
        */
        System.out.println("Pi value is : "+PI);
        System.out.println("Square of 5 is : "+ square(5));

        /*
        Benefits of Static Import:
        1. Conciseness: You avoid writing the class name repeatedly for static members.
        2. Readability: It makes the code easier to read, especially when frequently using constants or utility methods from a class.

        Caution:
        1. Overuse: While static imports can simplify code, overusing them can make your code harder to understand,
                 especially when multiple static methods have the same name from different classes.
        2. Readability: If many static imports are used in a file, it might make it unclear which class the static
                     members belong to. It is generally recommended to use them sparingly.
        */

        System.out.println("============================================================");

        // 2. Covariant Return
        /*
        It is a feature that allow a method in a subclass to override a method in the superclass and return a more
        specific (or derived) type than the one defined in the superclass.
         */

        class Shape {
            public Shape createShape() {
                return new Shape();
            }
        }

        class Circle extends Shape {
            @Override
            public Circle createShape() {
                return new Circle();
            }
        }

        //Covariant return allows for type-specific behavior without losing the polymorphic properties of inheritance.
        Shape shape = new Shape();
        Shape circleShape = new Circle();
        System.out.println(shape.getClass().getSimpleName());
        System.out.println(circleShape.getClass().getSimpleName());

        /*

        Common Use Cases:
        1. Factory Methods: When using factory methods that return objects of specific types in subclasses
                            (like a ShapeFactory class that returns different shapes).
        2. Fluent APIs: When designing APIs that chain methods and want to return the same subclass type for
                            further method calls (i.e., returning this for method chaining in a subclass).

        A covariant return can only be used when overriding methods are public or protected, not private.
         */

        System.out.println("============================================================");

        /* Enhanced for loop (also called for-each loop)
        It is to simplify the iteration over collections, arrays, and other iterable structures. It eliminates the
        need for explicitly managing the loop counter or the iterator, making the code more readable and less error-prone.

         */

        int[] intArray = {55, 22, 33, 77};
        System.out.println("{55, 22, 33, 77} array printed using for-each loop: ");
        for(int ele : intArray) {
            System.out.println(ele);
        }
        List<String> stringList = List.of("Coupe", "Sedan", "SUV", "Truck");
        System.out.println(stringList+" printed using for-each loop: ");
        for(String ele : stringList) {
            System.out.println(ele);
        }
        /*
        Limitations of the Enhanced For Loop:
        1. No Index Access: You cannot directly access the index of the current element inside the loop.
                            If you need the index, you will need to revert to the traditional for loop.
        2. Modification of Collection: You cannot modify the collection (e.g., adding/removing elements) while
                                        iterating with the enhanced for loop. (Throws ConcurrentModificationException)
        3. Limited to Iterables: The enhanced for loop can only be used with arrays and collections
                                (or any object that implements Iterable). It cannot be used for primitive
                                data types that are not arrays or for other non-iterable data structures.
         */

        System.out.println("============================================================");

        /* Var-args method parameter
        var-args is the variable-length argument that can hold zero or more arguments

        1. Syntax: Var-args are declared using three dots (...) followed by the type of the arguments.
                    public void methodName(Type... args) { }
        Parameter Position: The var-args parameter must be the last parameter in the method signature.
        Array: Internally, var-args are treated as an array, so you can access them as an array inside the method.
        Single Var-args: A method can only have one var-args parameter, and it must be the last parameter in
                         the method signature.
        Usage: Var-args are typically used for methods that can accept an arbitrary number of arguments,
                like println() in System.out.
         */

        /*
        public static void varArgsMethod(int... numbers) {
            for(int number : numbers) {
                System.out.println(number);
            }
        }
        */

        System.out.println("7 Parameters: ");
        varArgsMethod(5,6,2,0,3,7,1);
        System.out.println("2 Parameters: ");
        varArgsMethod(30,43);
        System.out.println("No Parameters: ");
        varArgsMethod();

        System.out.println("============================================================");

        /* Enumeration (enum) in java
        enum is a special type of class that represents a collection of constants
         (unchangeable variables, like final variables).

         Enumerations are useful when you have a fixed set of related constants, such as days of the week,
         months of the year, directions, and more

         Key Points:
         1. Type-Safety: Enums provide a type-safe way to work with constant values, ensuring that only
                        valid constants are used.
        2. Implicitly extends java.lang.Enum: Every enum in Java implicitly extends java.lang.Enum, which
                        provides several useful methods like values(), valueOf(), and ordinal().
        3. Enums Can Have Fields and Methods: Enums can have fields, constructors, and methods, making them much
                        more powerful than simple constants.
        4. Improved Readability: Using enums helps improve code readability and reduces errors compared
                        to using traditional constants (like public static final).

        Enum Methods - values(), valueOf(), and ordinal()
        Java provides several built-in methods to work with enums:

        values(): Returns an array of all the enum constants.
        valueOf(): Returns the enum constant corresponding to the given string. (Converts String to
                    corresponding enum constant)
        ordinal(): Returns the position of the enum constant in the declaration (starting from 0)
         */

        //basic enum
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        }

        Day[] days = Day.values();
        for(Day day : days) {
            System.out.print(day + " ");
        }
        System.out.println();

        Day dayy = Day.valueOf("MONDAY");
        System.out.println("Value of 'MONDAY' in enum Day is "+dayy);

        int pos = Day.FRIDAY.ordinal();
        System.out.println("Ordinal of FRIDAY is : "+pos);

        //enum with Fields, Constructor, and Methods
        enum carType {
            COUPE(2), SEDAN(5), SUV(7), TRUCK(3);

            private int seatCapacity;//field

            carType(int seatCapacity) {
                this.seatCapacity = seatCapacity;
            }

            public int getSeatCapacity() {
                return seatCapacity;
            }

        }

        carType coupeCar = carType.COUPE;

        System.out.println("Capacity of Coupe car is " +coupeCar.getSeatCapacity());// 2
        System.out.println("Capacity of Sedan car is " +carType.SEDAN.getSeatCapacity());// 5

        DayOfWeek day = LocalDateTime.now().getDayOfWeek();//return enum of type DayOfWeek
        System.out.println("Today is "+day);
        switch (day) {
            case MONDAY:
                System.out.println("Start of Week");
                break;
            case FRIDAY:
                System.out.println("Almost Weekend!");
                break;
            case SUNDAY:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Regular Day");
        }

        // enum with abstract methods
        enum Shape1 {
            CIRCLE {
                @Override
                public double area() {
                    return Math.PI * 5 * 5; // Example for a circle with radius 5
                }
            },
            SQUARE {
                @Override
                public double area() {
                    return 4 * 4; // Example for a square with side 4
                }
            };

            // Abstract method to be implemented by enum constants
            public abstract double area();
        }

        System.out.println("Area of CIRCLE: " + Shape1.CIRCLE.area());
        System.out.println("Area of SQUARE: " + Shape1.SQUARE.area());

    }

    public static void varArgsMethod(int... numbers) {
        for(int number : numbers) {
            System.out.println(number);
        }
    }
}