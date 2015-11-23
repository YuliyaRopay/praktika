package day4.frame25;

/**
 * Created by julia on 20.06.2015.
 */
public class ReferenceLauncher {
    public static void main(String[] args) {

        Reference ref1=new Reference("ref1");
        Reference ref2=new Reference("ref2");
        Reference ref3=new Reference("ref3");
        ref1.setReference(ref2);
        ref2.setReference(ref3);
        ref3.setReference(ref1);

        ref1.print();
        ref2.print();
        ref3.print();
    }
}
