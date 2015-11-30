package day5.autoboxing;

import com.sun.org.apache.xpath.internal.SourceTree;

public class TestJava18 {
    public static void main(String[] args) {

        Integer a=10;
        Integer b=20;

        sum(a,b);
    }

    public static void sum(int a, int b){
        System.out.println(a+b);
    }
}
