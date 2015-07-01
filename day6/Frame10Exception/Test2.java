package day6.Frame10Exception;


public class Test2 {
    public static void main(String[] args) {
        try {

            Test2.testMethod();

        } catch (InterruptedException e) {
            System.out.println("Test <try ... catch> block");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            System.out.println("print all yhe time");
        }

    }

    public static void testMethod() throws  InterruptedException{
        Thread.sleep(1000);
    }
}
