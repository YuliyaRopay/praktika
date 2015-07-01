package day6.Frame10Exception;

public class Test1 {
    public static void main(String[] args) {
        Test1.testMethod();
    }

    public static void testMethod() {
        try {

            // test 1 - InterruptedException
            // Thread.currentThread().interrupt();
            //Thread.sleep(1000);

            //test 2 - IllegalArgumentException
            Thread.sleep(-1000);

        } catch (InterruptedException e) {
            System.out.println("Test <try ... catch> block");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Test error input data");
            System.out.println(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


