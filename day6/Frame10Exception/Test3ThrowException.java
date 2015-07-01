package day6.Frame10Exception;

/**
 * Created by julia on 25.06.2015.
 */
public class Test3ThrowException {
    public static void main(String[] args) {
        int a=5;
        int b=0;

        if (b==0){
            throw new MyPersonalException("Error! b=0");
        }
        else{
            int c=a/b;
            System.out.println(c);
        };
    }
}
