public class C04ImmutableString {

    /*
    General strings which are objects of String class are immutable
    i.e they cannot be modified once they are created

    Methods to compare strings
    1. == : compares string references i.e addresses of string objects
    2. equals() : compares string objects i.e values/literals
    3. equalsIgnoreCase() : literals will be compared case is not significant
    4. compareTo() : compares char by char returns which is greater acc. to lex order
    5. concat() : generates new string which is concatenation of given strings

    6. subString(int,int)
    7. toUpperCase()
    8. toLowerCase()
    9. length()
    10. charAt()
    11. hashCode()


    > What is SCP - String Constant Pool?

     */
    {
        String s1="news";//string created in SCP in Heap area
        String s2="news";
        String s3=new String("news");//string created in Heap area out of SCP
        String s4=new String(new char []{'N','e','w','s'});//"News"
        // String s4=new String({'N','e','w','s'}); // this is wrong

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equalsIgnoreCase(s3));//true
        System.out.println(s1.compareTo(s4));// int(n)-int(N)=32 i.e returns an interger
        String s5=s1.concat("think");//strings are immutable s1 is not changed
        System.out.println(s5);//newsthink
        System.out.println(s1);

		/*
		 concat() method creates string during runtime, so memory is allocated in heap
		 area out of string constant pool. s1 is in string constant pool but s5 is in heap
		 area out of string constant pool.

		 Alternatively, you can use + to concatenate strings literals memory is
		 allocated in SCP for new concatenated strings.

		 But if you use string references instead of string literals while concatenating
		 them using + then memory is allocated out of SCP in heap

		 s1=s2+s3 //out of scp
		 s1="news"+"think"//scp
		 s1=s2+"think"//out of scp since s2 reference is involved in concatenation
		 */

        //operator overloading
        String s6="news"+10+10+5;
        //news10105 i.e "news10"+10+5=>"news1010"+5=>"news10105"

        String s7=10+10+5+"news";//"25news"

		/*
		 Type promotion has happened here, just like 20*1.0 gives
		 overall result in double
		 */

        System.out.println(s6);
        System.out.println(s7);

        String s8="manisharma".substring(4,10);
		/*
		 s8 = "sharma" s8 is created during runtime so
		 memory is allocated in heap out of SCP
		 */

        String s9=s8.substring(1,6);//"harma" allocated in heap out of SCP
        System.out.println(s8);
        System.out.println(s9);

        System.out.println(s1.toUpperCase());//NEWS
        System.out.println(s1.toUpperCase().toLowerCase());//news
        System.out.println(s1.charAt(1));//e

        System.out.println(s1.length());//4


        System.out.println(s3);//gives string value instead of address of string object
        System.out.println(s3.hashCode());
        //you cannot get address of string bt you can get hashcode

    }
}
