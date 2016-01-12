package day9.Adapter;

public class AdapterPatternDemo {

    public static void main(String[] args) {

        Target target1=new AdapterByObject();
        Target target2=new AdapterByClass();

        System.out.println(target1.newRequest());
        System.out.println(target2.newRequest());
    }
}
