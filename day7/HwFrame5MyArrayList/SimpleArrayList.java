package day7.HwFrame5MyArrayList;

import java.util.Iterator;

public class SimpleArrayList implements SimpleList, Iterable<Object>{

    private Object[] arrayList =new Object[0];

    public SimpleArrayList() {
        arrayList =new Object[0];
    }

    @Override
    public void add(Object object) {
        addLast(object);
    }

    //
    public void addLast(Object object){
        this.addByIndex(object, this.size());
    }

    //
    public void addFirst(Object object) {
        this.addByIndex(object, 0);
    }

    //
    public void addAfter(Object object, int index) {
        this.addByIndex(object, index);
    }

    //
    private void addByIndex(Object object, int index){

        int length=this.size();
        Object[] tmpArray=new Object[length+1];

        if (index>=0 && index<=length){
            for(int i=0;i<=length;i++){
                if(i<index){
                    tmpArray[i]=arrayList[i];
                }
                else if (i>index){
                    tmpArray[i]=arrayList[i-1];
                }
                else{
                    tmpArray[i]=object;
                }
            }

            arrayList=tmpArray;
        }
    }


    //
    @Override
    public void remove(Object object) {
        removeByIndex(getIndexOfObject(object));
    }

    //
    private void removeByIndex(int index){

       if (index<arrayList.length && index>=0){

           Object result=arrayList[index];
           Object[] tmpArray=new Object[size()-1];

            for(int i=0;i<size()-1;i++){
                if(i<index){
                    tmpArray[i]=arrayList[i];
                }
                else{
                    tmpArray[i]=arrayList[i+1];
                }
            }
            arrayList=tmpArray;
        }
    }

    //
    @Override
    public boolean contains(Object object) {
        return getIndexOfObject(object)>=0;
    }

    //
    private int getIndexOfObject(Object object){
        for(int i=0;i<size();i++){
            if ((arrayList[i]!=null && arrayList[i].equals(object)) ||
                    (arrayList[i]==null && object==null)){
                return i;
            }
        }
        return -1;
    }

    //
    @Override
    public int size() {
        return  arrayList.length;
    }


    @Override
    public String toString(){

        String resultString="";
        for(int i=0; i<arrayList.length;i++){
            if(arrayList[i]==null){
                resultString=resultString+"[null]";
            }
            else{
                resultString=resultString+"["+arrayList[i].toString()+"] ";
            }
        }

        return resultString;
    }


    @Override
    public Iterator<Object> iterator() {
        return new SALIterator();
    }


    //
    private class SALIterator implements Iterator<Object> {

        private int position=0;

        public SALIterator() {
        }

        @Override
        public boolean hasNext() {
            return position<arrayList.length;
        }

        @Override
        public Object next() {
            if(hasNext()){
                Object o=arrayList[position];
                position=position+1;
                return o;
            }
            else{
                throw new IllegalStateException("List has no more elements");
            }
        }
    }
}
