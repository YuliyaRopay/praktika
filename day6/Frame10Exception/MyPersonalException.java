package day6.Frame10Exception;

/**
 * Created by julia on 22.06.2015.
 */
public class MyPersonalException extends RuntimeException{

    public MyPersonalException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "MyException: "+super.getMessage();
    }
}
