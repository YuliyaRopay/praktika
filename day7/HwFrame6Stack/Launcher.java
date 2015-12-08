package day7.HwFrame6Stack;

public class Launcher {

    public static void main(String[] args) {

        Stack stack =new Stack();

        System.out.println(">>> Push ");
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack.toString());

        System.out.println();
        System.out.println(">>> Peek ");
        System.out.println(stack.peek().toString());

        System.out.println();
        System.out.println(">>> Pop ");
        System.out.println(stack.pop().toString());
        System.out.println(stack.toString());




    }
}
