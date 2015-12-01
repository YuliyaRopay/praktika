package day6.Frame10Exception;


public class MyPersonalException extends RuntimeException{

    public MyPersonalException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "MyException: "+super.getMessage();
    }
}
