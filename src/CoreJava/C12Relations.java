package CoreJava;/*
 In Java, we have two types of relationship:

 1. Is-A relationship:
 	Whenever one class inherits another class,
 	it is called an IS-A relationship.

 2. Has-A relationship:
 	Whenever an instance of one class is used in
 	another class, it is called HAS-A relationship.

 	Has-A relation defines associations btn 2 classes in java application

 Four types of associations in java => 1:1, 1:M, M:1, M:N

 Dependency Injection : The process of injecting dependent object into
 	target object is called Dependency Injection. This can be done using
 	either constructor (constructor injection) or setter methods (setter
 	method injection)


 	What is aggregation and composition in Java?
 	- Association is of 2 types : Aggregation and Composition

 	Aggregation: In an association if Target Object can exist even without Dependent Object then such type of
 	association is called Aggregation [loose coupling]
 	example - Library class can exist without Student class in it

 	Composition: In an association if Target Object cannot exist without Dependent Object then such type of
 	association is called Composition [tight coupling]
 	example - Library class cannot exist without Book class in it
 */

public class C12Relations {

    public static void main(String[] args) {

        Address addr1 = new Address("USA", "Kansas", "Overland Park", 66223);
        Address addr2 = new Address("USA", "Kansas", "Olathe", 66045);
        //each student has only one address; 1:1

        MobileNumber MN1[] = new MobileNumber[2];
        MN1[0]= new MobileNumber("+91", "9121566421");
        MN1[1]= new MobileNumber("+1", "9132339307");
        MobileNumber MN2[] = new MobileNumber[2];
        MN2[0]= new MobileNumber("+91", "9848249485");
        MN2[1]= new MobileNumber("+1", "9132800824");
        //each student can have multiple phone numbers; 1:M

        Instructor instructor1 = new Instructor("Wang", "Stats", 14200);
        Instructor instructor2 = new Instructor("Rawashdeh", "BDA", 54120);
        Instructor instructor3 = new Instructor("Kang", "ASE", 47100);
        Instructor []instructors1 = new Instructor[3];
        instructors1[0] = instructor1;
        instructors1[1] = instructor2;
        instructors1[2] = instructor3;
        Instructor []instructors2 = new Instructor[2];
        instructors2[0] = instructor2;
        instructors2[1] = instructor3;

        Department dept = new Department("CS",1245);



        Student []st = new Student[2];
        st[0] = new Student("Math", "17881A05B7", 24, addr1, MN1, dept, instructors1);
        st[1] = new Student("Rohan", "17881A05R4", 24, addr2, MN2,dept, instructors2);
        //multiple Students can have one Department; M:1
        //multiple students can have multiple instructors and vice versa; M:N


        for(Student s:st) {
            System.out.print("Student : ");
            System.out.println(s.getName());
            System.out.println(s.getID());
            System.out.println(s.getAge());
            System.out.println(s.getAddress());
            System.out.println(s.getMobileNumber());
            System.out.println(s.getDepartment());
            System.out.println(s.getInstructors());
            System.out.println();
        }
    }

}

class Address{//dependent object
    String country;
    String state;
    String city;
    int zipcode;

    Address(String coun,String st,String cit,int zip){
        country=coun;
        state=st;
        city=cit;
        zipcode=zip;
    }
}

class MobileNumber{
    String countrycode;
    String contactnum;

    MobileNumber(String cc, String cn){
        countrycode = cc;
        contactnum = cn;
    }
}

class Instructor{//dependent object
    String name;
    String course;
    int CRN;

    Instructor(String name, String course, int CRN){
        this.name=name;
        this.course=course;
        this.CRN=CRN;
    }
}

class Department{//dependent object
    String dname;
    int did;

    Department(String dname, int did){
        this.dname=dname;
        this.did=did;
    }
}

class Student{//target object
    String name;
    String ID;
    int age;

    //Has-A relationship
    Address address;// 1:1 association i.e one student has one address
    MobileNumber []mobilenum;// 1:M association i.e one student has many mobile numbers
    Department department;//M:1 association i.e many students have a single department
    Instructor []instructors;

    Student(String name, String ID, int age, Address address, MobileNumber []mnum, Department department, Instructor []instructors){
        this.name=name;
        this.ID=ID;
        this.age=age;
        this.address=address;//1:1 dependency injection using constructor
        this.mobilenum=mnum;//1:M dependency injection using constructor
        this.department=department;
        this.instructors=instructors;
    }

    //getters

    String getName() {
        return name;
    }

    String getID() {
        return ID;
    }

    int getAge() {
        return age;
    }

    String getAddress() {
        return address.country+", "+address.state+", "+address.city+", "+address.zipcode;
    }

    StringBuilder getMobileNumber() {
        StringBuilder res=new StringBuilder();
        int n=mobilenum.length;
        for(int i=0;i<n;i++) {
            if(i==n-1)
                res.append(mobilenum[i].countrycode+" "+mobilenum[i].contactnum);
            else
                res.append(mobilenum[i].countrycode+" "+mobilenum[i].contactnum+"\n");
        }
        return res;
    }


    String getDepartment() {
        return department.dname+", "+department.did;
    }

    String getInstructors() {
        String temp = "";
        int n=instructors.length;
        for(int i=0;i<n;i++) {
            if(i==n-1)
                temp = temp.concat(instructors[i].name);
            else
                temp = temp.concat(instructors[i].name+", ");
        }
        return temp;
    }

}