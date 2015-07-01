package day4;

/**
 * Created by julia on 20.06.2015.
 */
public class Frame25ReferenceLauncher {
    public static void main(String[] args) {

        Frame25Reference ref1=new Frame25Reference("ref1");
        Frame25Reference ref2=new Frame25Reference("ref2");
        Frame25Reference ref3=new Frame25Reference("ref3");
        ref1.setReference(ref2);
        ref2.setReference(ref3);
        ref3.setReference(ref1);

        ref1.print();
        ref2.print();
        ref3.print();
    }
}
