package day7.Frame9MyLinkedList;

import java.util.Objects;

public class Node {
    private Object object;
    private Node node;

    public Node(Object object){
        this.object=object;
    }

    public Node(Object object, Node node){
        this.object=object;
        this.node=node;
    }


}
