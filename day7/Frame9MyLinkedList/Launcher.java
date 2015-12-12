package day7.Frame9MyLinkedList;

import java.util.Iterator;

public class Launcher {
    public static void main(String[] args) {

        SimpleLinkedList simpleLinkedList =new SimpleLinkedList();

        System.out.println(">>> add first");
        simpleLinkedList.addFirst(1);
        simpleLinkedList.addFirst(2);
        simpleLinkedList.addFirst(3);
        simpleLinkedList.addFirst(4);
        System.out.println(simpleLinkedList.toString());

        System.out.println();
        System.out.println(">>> add last");
        simpleLinkedList.addLast("a");
        simpleLinkedList.addLast("b");
        simpleLinkedList.addLast("c");
        simpleLinkedList.addLast("d");
        System.out.println(simpleLinkedList.toString());

        System.out.println();
        System.out.println(">>> add after");
        simpleLinkedList.addAfter("k", "q");
        simpleLinkedList.addAfter("f","a");
        simpleLinkedList.addAfter("c","c");
        simpleLinkedList.addAfter("s",4);
        simpleLinkedList.addAfter("dd", "d");
        simpleLinkedList.addAfter("h", "dd");
        System.out.println(simpleLinkedList.toString());

        System.out.println();
        System.out.println(">>> iterator");
        for(Object o:simpleLinkedList){
            System.out.println(o.toString());
        }


        System.out.println();
        System.out.println("-->>>iterator remove a, c");
        for(Iterator<Object> it = simpleLinkedList.iterator();it.hasNext();){
            Object o =it.next();
            if(o.equals("a") || o.equals("c")){
                it.remove();
            }
        }
        Iterator<Object> it2 = simpleLinkedList.iterator();
        do{
            System.out.println(it2.next());
        }while(it2.hasNext());
    }
}
