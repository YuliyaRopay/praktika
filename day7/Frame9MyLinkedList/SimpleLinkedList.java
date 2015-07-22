package day7.Frame9MyLinkedList;


import java.util.Iterator;

public class SimpleLinkedList implements Iterable<Object> {
    private Node nodeRoot;
    private int size;

    public SimpleLinkedList(){
        size=0;
        nodeRoot=null;
    }

    public SimpleLinkedList(Object object){
        this();
        this.addFirst(object);
    }


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

        /*
        Node n=new Node();
        n.object=object;
        if(nodeRoot!=null){
            n.ref=nodeRoot;

        }
        nodeRoot=n;
        size++;
        */
    }

    public void addLast(Object object){
        if(object!=null){
            Node nodeTmp=new Node();
            nodeTmp.object=object;
            if(nodeRoot==null){
                nodeRoot=nodeTmp;
            }
            else{
                Node nodeLast=nodeRoot;
                Node nodeRef=nodeRoot;
                while (nodeRef.ref!=null){
                    nodeLast=nodeRef;
                    nodeRef=nodeRef.ref;
                }
                nodeRef.ref=nodeTmp;
            }
            addSize();
        }
    }

    public void addAfter(Object object, Object prev){
        Node nodePrev=null;
        Node nodeCurrent=nodeRoot;
        do{
            if(nodeCurrent.object==prev){
                nodePrev=nodeCurrent;
                break;
            }
            nodeCurrent=nodeCurrent.ref;
        }while(nodeCurrent!=null && nodeCurrent.ref!=null);

        if(nodePrev==null){
            throw new IllegalStateException("List doesn't contain prev object.");
        }
        Node nodeTmp=new Node();
        nodeTmp.object=object;

        if(nodePrev.ref!=null){
            nodeTmp.ref=nodePrev.ref;
        }

        nodePrev.ref=nodeTmp;
        addSize();

    }

    private void addSize(){
        size++;
    }

    private void subtractSize(){
        size--;
    }

    public int getSize(){
        return size;
    }

    public void printAll(){
        if(size==0){
            System.out.println("Empty");
        }

        Node node=nodeRoot;
        while (node.ref!=null){
            System.out.println(node.object+"->"+node.ref.object);
            node=node.ref;
        }
        System.out.println(node.object);

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

        private Node cp;
        private Node prev;

        public SLLIterator() {
        }

        @Override
        public boolean hasNext() {
            return (cp==null && nodeRoot!=null)||(cp!=null && cp.ref!=null);
        }

        @Override
        public Object next() {
            if(cp==null && nodeRoot!=null){
                cp=nodeRoot;
                return cp.object;
            }
            if(hasNext()){
                cp=cp.ref;
                return cp.object;
            }
            throw new IllegalStateException("List has no more elements");
        }

        @Override
        public void remove() {
            if(!hasNext()&&prev==null){
                //only one element
                cp=null;
                nodeRoot=null;
            }else if(!hasNext()&&prev!=null){
                //last element
                prev.ref=null;
                cp=null;
            }else if(hasNext()&&prev==null){
                //first
                nodeRoot=cp.ref;
                cp=nodeRoot;
            }else{
                //middle
                prev.ref=cp.ref;
                cp=cp.ref;
            }
            size--;

        }
    }
}
