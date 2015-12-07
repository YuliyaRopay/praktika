package day7.HwFrame5MyArrayList;

import java.util.Iterator;

public class SimpleArrayList implements Iterable<Object>{

    private Object[] arrayList =new Object[0];

    public SimpleArrayList() {
        arrayList =new Object[0];
    }

    //
    public void addLast(Object object){
        this.add(object,this.getSize());
    }

    //
    public void addFirst(Object object) {
        this.add(object, 0);
    }

    //
    public void addAfter(Object object, int index) {
        this.add(object, index);
    }

    //
    private void add(Object object, int index){

        int length=this.getSize();
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
    public void remove(int index){

        Object result=arrayList[index];
        Object[] tmpArray=new Object[getSize()-1];

        if (index<arrayList.length && index>=0){
            for(int i=0;i<getSize()-1;i++){
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
    public int getSize(){
        return arrayList.length;
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
