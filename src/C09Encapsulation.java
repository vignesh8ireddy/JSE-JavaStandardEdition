public class C09Encapsulation {

	/*
	 Encapsulation is a fundamental concept in object-oriented programming (OOP)
	 that refers to the bundling(or binding) of data and, methods that operate on
	 that data within a single unit, which is called a class in Java.

	 Encapsulation is a way of hiding the implementation details of a class from
	 outside access and only exposing a public interface that can be used to interact
	 with the class.

	 In Java, encapsulation is achieved by declaring the instance variables of a
	 class as private, which means they can only be accessed within the class. To
	 allow outside access to the instance variables, public methods called getters
	 and setters are defined, which are used to retrieve and modify the values of the
	 instance variables, respectively. By using getters and setters, the class can
	 enforce its own data validation rules and ensure that its internal state remains
	 consistent.
	 */

    //public int age; this data is vulnerable anyone could access it outside the class

    private int age;//only members of this class can access data

    //methods to access data
    public void setAge(int age) {
        //protect data from outsiders with restrictions
        if(age<=0 || age>120)
            System.out.println("access denied, invalid data");
        else
            this.age=age;

		/*
        These are very trivial restrictions but you can strengthen
        them using other concepts such as date, time, and many other
        powerful things
		*/
    }

    public int getAge() {
        //add restrictions according to your requirement
        return this.age;

    }

	/*
	 The restrictions used here are just nominal to explain the encapsulation concept,
	 in real-time restrictions would be lot powerful.
	 */

}
