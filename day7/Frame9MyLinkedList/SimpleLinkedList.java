package day7.Frame9MyLinkedList;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object>{

    private Node nodeRoot;
    private int size;

    public SimpleLinkedList() {
        size=0;
        nodeRoot=null;
    }

    public SimpleLinkedList(Object object){
        this();
        this.addFirst(object);
    }

    //
    public Node getNodeRoot() {
        return nodeRoot;
    }

    public int getSize() {
        return size;
    }

    //
    public void addFirst(Object object){
        if(object!=null){
            Node nodeTmp=new Node();
            nodeTmp.object=object;
            if (nodeRoot==null){
                nodeTmp.ref=null;
            }
            else{
                nodeTmp.ref=nodeRoot;
            }
            nodeRoot=nodeTmp;
            addSize();
        }
    }

    //
    public void addLast(Object object){
        if(object!=null){
            Node nodeTmp=new Node();
            nodeTmp.object=object;
            Node nodeLast=getLastNode();
            if(nodeLast==null){
                nodeRoot=nodeTmp;
            }
            else{
                nodeLast.ref=nodeTmp;
            }
            addSize();
        }
    }


    //
    public void addAfter(Object object, Object prev){
        if(object!=null){
            Node nodeTmp=new Node();
            nodeTmp.object=object;
            Node nodePrev=getNode(prev);
            if(nodePrev!=null){
                nodeTmp.ref=nodePrev.ref;
                nodePrev.ref=nodeTmp;
                addSize();
            }
        }
    }



    //
    private Node getLastNode(){
        Node node=nodeRoot;
        Node nodeTmp=nodeRoot;
        while (node!=null){
            nodeTmp=node;
            node=node.ref;
        }
        return nodeTmp;
    }

    //
    private Node getNode(Object object){
        Node node=nodeRoot;
        while (node!=null){
            if(node.object.equals(object)){
                return node;
            }
            node=node.ref;
        }
        return null;
    }

    //
    private void addSize(){
        size++;
    }

    //
    @Override
    public String toString() {
        String resultString="";
        Node node=nodeRoot;
        while(node!=null){
            resultString=resultString+"["+node.object.toString()+"]";
            node=node.ref;
        }
        return resultString;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    //
    private class Node {
        private Object object;
        private Node ref;

    }

    //
    private class SLLIterator implements Iterator<Object>{

        Node nodeCurrent;
        Node nodePrev;

        public SLLIterator() {
            nodeCurrent=nodeRoot;
            nodePrev=null;
        }

        @Override
        public boolean hasNext() {
            if(nodeCurrent.ref!=null){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(hasNext()){
                nodePrev=nodeCurrent;
                nodeCurrent=nodeCurrent.ref;
                return nodeCurrent.object;
            }
            throw new IllegalStateException("No more elements");
        }

        @Override
        public void remove() {
            if(nodeCurrent!=null){
                if(nodePrev==null && !hasNext()){
                    nodeCurrent=null;
                    nodeRoot=null;
                }
                else if(nodePrev!=null && !hasNext()){
                    nodePrev.ref=null;
                    nodeCurrent=null;
                }
                else if(nodePrev==null && hasNext()){
                    nodeRoot=nodeCurrent.ref;
                    nodeCurrent=nodeRoot;
                }
                else{
                    //System.out.println(">>>> "+nodeCurrent.object.toString());
                    nodePrev.ref=nodeCurrent.ref;
                    nodeCurrent=nodePrev;
                    //nodeCurrent=nodeCurrent.ref;
                    //System.out.println(">>>> nodePrev "+nodePrev.object.toString());
                    //System.out.println(">>>> nodePrev ref "+ nodePrev.ref.object.toString());
                    //System.out.println(">>>> nodeCurrent "+nodeCurrent.object.toString());
                }
            }
        }
    }
}
