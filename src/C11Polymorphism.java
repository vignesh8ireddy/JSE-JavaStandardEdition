public class C11Polymorphism {
    public static void main(String[] args) {

        //Method Hiding :
        P pq = new Q();
        pq.showMe();// "I'm P"
        P pr = new R();
        pr.showMe();// "I'm P"
        P p = new P();
        p.showMe();// "I'm P"

        //No Polymorphism

        R rr = new R();// 1:1 //tightly coupled i.e rr is coupled with only R
        rr.sayHi();//HI, I'm R
        Q qq = new Q();// 1:1 //tightly coupled, qq is coupled with only q
        qq.sayHi();//HI, I'm Q

        //Polymorphism

        P pp;
        pp = rr;
        pp.sayHi();// HI, I'm R
        pp = qq;
        pp.sayHi();// HI, I'm Q
        //pp.sayHi(); same lines with multiple behavior

		/*
		 You should define methods within a class, not inside another method.
		 ImplementPolymorphism method must be static to be called by another static
		 method.
		 */

        ImplementPolymorphism(new S());
        ImplementPolymorphism(new R());
        ImplementPolymorphism(new Q());
    }

    static void ImplementPolymorphism(P p) {
        p.sayHi();// same line but has multiple behavior; [1:M]
        //loosely coupled i.e upcasted
    }


}

class P{
    public static void showMe() {
        System.out.println("I'm P");
    }

    public void sayHi() {
        System.out.println("HI, I'm P.");
    }
}

class Q extends P{
    public static void showMe() {
        System.out.println("I'm Q");
    }
    public void sayHi() {
        System.out.println("HI, I'm Q");
    }
}

class R extends P {
    public static void showMe() {
        System.out.println("I'm R");
    }
    public void sayHi() {
        System.out.println("HI, I'm R");
    }
}

class S extends P {
    public static void showMe() {
        System.out.println("I'm S");
    }
    public void sayHi() {
        System.out.println("HI, I'm S");
    }
}
