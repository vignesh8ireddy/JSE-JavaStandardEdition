public class C01Literals {

    byte b=3; //int literal (Definition)
    short s=411;//int literal
    int i,q,w,e; // (Only Declaration)
    long l=452399933L;//long literal



    C01Literals() {

        i=5544646;//int literal in decimal
        q=0b0101;//int 5 literal in binary
        w=045;//int 37 literal in octal
        e=0xA;//int 10 literal in hexadecimal

    }


    public void showLiterals(){
        System.out.println("b = "+b+
                "\ns = "+s+
                "\ni = "+i+
                "\nl = "+l+
                "\nq = "+q+
                "\nw = "+w+
                "\ne = "+e);
    }



}
