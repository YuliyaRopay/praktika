package day7.Frame9MyLinkedList;

import java.util.Iterator;

public class Launcher {
    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList=new SimpleLinkedList();
        simpleLinkedList.addFirst(1);
        simpleLinkedList.addFirst(2);
        simpleLinkedList.addFirst(3);
        simpleLinkedList.printAll();

        System.out.println("-->>>");
        simpleLinkedList.addLast(4);
        simpleLinkedList.addLast(5);
        simpleLinkedList.printAll();

        System.out.println("-->>>");
        simpleLinkedList.addAfter(0,3);
        simpleLinkedList.printAll();


        System.out.println("-->>>iterator");
        for(Object o: simpleLinkedList){
            Integer integer=(Integer)o;
            System.out.println(integer);
        }

        System.out.println("-->>>iterator2");
        for(Iterator<Object> it =simpleLinkedList.iterator();it.hasNext();){
            Object o =it.next();
            System.out.println(o);
        }
    }
}
