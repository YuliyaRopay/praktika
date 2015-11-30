package day5.autoboxing;

public class TestJava14 {
    public static void main(String[] args) {

        Integer a=new Integer(10);
        Integer b=new Integer(20);

        sum(a.intValue(),b.intValue());
    }

    public static void sum(int a, int b){
        System.out.println(a+b);
    }
}
