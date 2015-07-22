package day7.HwFrame6Stack;

import java.util.LinkedList;
import java.util.List;

public class Stack {
    private LinkedList<Object> stackList;

    public Stack() {
        stackList=new LinkedList<Object>();
    }

    public void push(Object object){
        stackList.add(object);
    }

    public Object peak(int index){
        return stackList.get(index);
    }

    public int getSize(){
        return stackList.size();
    }

    public void printAll(){
        System.out.print("[");
        for(Object o:stackList){
            System.out.print(o.toString() + " ,");
        }
        System.out.println("]");
    }


}
