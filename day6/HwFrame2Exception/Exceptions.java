package day6.HwFrame2Exception;


public class Exceptions {
    public static void main(String[] args) {
        catcher();
        System.out.println("done");
    }

    public static void catcher(){
        try{
            return;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("I want to be executed!!!");
        }
    }
}
