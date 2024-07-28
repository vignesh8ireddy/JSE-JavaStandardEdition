public class C08MutableString {

    public static void main(String[] args) {

        StringBuilder s1 = new StringBuilder("news");
        StringBuilder s2 = new StringBuilder("news");

        System.out.println(s1.equals(s2));//false

		/*
		 equals() method is not available in StringBuilder class, so equals() of Object class is
		 implemented here which compares references not values (like == operator) unlike equals()
		 method of String class
		 */

        System.out.println(s1==s2);//false

        //final vs mutability

        final StringBuilder s3=new StringBuilder("hey");
        s3.append(" buddy");
        /*
        though s3 is final it can be modified
        but it cannot be re-assigned
         */

        System.out.println(s3);//"hey buddy"

		/*
		 s3 = new StringBuilder("woww");
		 CTE, you cannot reassign final reference variable
		 */


        /*
        StringBuilder Methods
         * capacity() :
            1. default capacity for empty string is 16 characters
            2. default capacity for non empty string is string length plus 16
            3. after completion of default capacity in both cases, new capacity
               will be (default capacity+1)*2
         */

        StringBuilder sb1=new StringBuilder();//empty string
        System.out.println(sb1.capacity());//16
        System.out.println(sb1.append("0123456").capacity());//16
        System.out.println(sb1.append("789ABCDEF").capacity());//16
        System.out.println(sb1.append("Z").capacity());//(16+1)*2=34
        System.out.println(sb1.append("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz").capacity());//(34+1)*2


        StringBuilder sb2=new StringBuilder("0123456");
        System.out.println(sb2.capacity());//7+16=23
        System.out.println(sb2.append("ZZZZYYYYXXXXWWWW").capacity());//23
        System.out.println(sb2.append("VVVV").capacity());//(23+1)*2=48
        System.out.println(sb2.append("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY").capacity());
        //(48+1)*2


        StringBuilder sb3=new StringBuilder(21);//building empty string with capacity 21
        System.out.println(sb3);//empty String
        System.out.println(sb3.capacity());//21

        /*
            1.length()
            2.append()//can overload : append(string/boolean/float)
            3.insert()//can overload : insert(int, string/char/int/float)
            4.delete(start index, end index) : deletes start index to end index-1
            5.deleteCharAt(index)
            6.reverse()
            7.setLength() : trims the string from starting to the given length
            8.trimToSize() : reduces the capacity of the string to its current length
            9.ensureCapacity() : increases capacity of the string to specified limit
         */

        StringBuilder str1=new StringBuilder("news");//str1="news"
        str1.append("think");
        System.out.println(str1);//"newsthink"
        str1.append(false);
        System.out.println(str1);//"newsthinkfalse"
        str1.append(3.1);
        System.out.println(str1);//"newsthinkfalse3.1"


        StringBuilder str2=new StringBuilder("xxxx");
        System.out.println(str2);//xxxx
        str2.insert(1, "yyy");
        System.out.println(str2);//xyyyxxx
        str2.insert(2, false);
        System.out.println(str2);//xyfalseyyxxx
        str2.insert(3, 'p');
        System.out.println(str2);//xyfpalseyyxxx
        str2.insert(4, 15);
        System.out.println(str2);//xyfp15alseyyxxx
        str2.insert(5, 3.222);
        System.out.println(str2);//xyfp13.2225alseyyxxx


        str2.delete(3,11);//xyfalseyyxxx
        System.out.println(str2);

        str2.deleteCharAt(6);//xyfalsyyxxx
        System.out.println(str2);


        str2.reverse();
        System.out.println(str2);//xxxyyslafyx

        str2.setLength(6);
        System.out.println(str2);//xxxyys

        StringBuilder str3=new StringBuilder(1000);//empty string with capacity 1000 characters
        str3.append("hey");
        System.out.println(str3.capacity());//1000
        System.out.println(str3.length());//3
        str3.trimToSize();
        System.out.println(str3.capacity());//3

        str3.ensureCapacity(100);
        System.out.println(str3.capacity());//100


        /*
         StringBuilder	vs	 StringBuffer

         StringBuilder :
            1. java 1.5
            2. all methods here are not synchronised (multiple threads can be operated at a time on stringbuilder object)
            3. multithreaded
            4. high performance

         StringBuffer :
            1. java 1.0
            2. all methods here are synchronised (only one thread can be operated at a time on stringbuffer object because of mutual exclusion)
            3. singlethreaded
            4. low performance
         */

    }

}
