package day4;


public class Frame10GreetingService {
    public static void main(String[] args) {
        if(args != null && args.length>=2){
            System.out.println("Hello " + args[0]+" "+args[1]);
        }
        else{
            System.out.println("Error! You must enter two parameters (name and surname) "
                    + "to run the program !");
        }
    }
}
