package day7.HwFrame5MyArrayList;

public class SimpleArrayList {
    private Object[] arrayList =new Object[0];

    public SimpleArrayList() {
        arrayList =new Object[0];
    }


    public void addLast(Object object){
        int length=arrayList.length;
        Object[] tmpArray=new Object[length+1];
        for(int i=0; i<length;i++)
            tmpArray[i]=arrayList[i];
        tmpArray[length]=object;
        arrayList=tmpArray;
    }

    public void add(Object object, int index){
        int length=arrayList.length;
        Object[] tmpArray=new Object[length+1];
        if (index<length && index>=0){
            for(int i=0;i<=length;i++){
                if(i<index)
                    tmpArray[i]=arrayList[i];
                else if (i>index)
                    tmpArray[i]=arrayList[i-1];
                else
                    tmpArray[i]=object;
            }
            arrayList=tmpArray;
        }
    }


    public void remove(int index){
        Object result=arrayList[index];
        Object[] tmpArray=new Object[getSize()-1];
        if (index<arrayList.length && index>=0){
            for(int i=0;i<getSize()-1;i++){
                if(i<index)
                    tmpArray[i]=arrayList[i];
                else
                    tmpArray[i]=arrayList[i+1];
            }
            arrayList=tmpArray;
        }
    }


    public int getSize(){
        return arrayList.length;
    }


    public void printArray(){
        System.out.println();
        for(int i=0; i<arrayList.length;i++){
            System.out.println(i+"="+arrayList[i]);
        }
    }

}
