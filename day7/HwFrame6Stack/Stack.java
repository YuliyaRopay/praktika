package day7.HwFrame6Stack;

import java.util.LinkedList;
import java.util.List;

public class Stack {

    private LinkedList<Object> stackList;

    public Stack() {
        stackList=new LinkedList<Object>();
    }

    public void push(Object object){
        stackList.push(object);
    }


    public Object peek(){
        return stackList.peek();
    }

    public Object pop(){

        return stackList.pop();

    }

    public int getSize(){
        return stackList.size();
    }


    @Override
    public String toString() {

        String resultString="";
        for(Object o: stackList){
            if(o==null){
                resultString=resultString+"[null]";
            }
            else{
                resultString=resultString+"["+o.toString()+"] ";
            }
        }

        return resultString;
    }

}
