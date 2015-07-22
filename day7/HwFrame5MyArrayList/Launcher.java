package day7.HwFrame5MyArrayList;


public class Launcher {
    public static void main(String[] args) {
        SimpleArrayList arrayList=new SimpleArrayList();
        arrayList.addLast("one");
        arrayList.addLast("two");
        arrayList.addLast("tree");
        arrayList.printArray();

        arrayList.add("five", 1);
        arrayList.add("one_one",0);
        arrayList.printArray();

        arrayList.remove(4);
        arrayList.printArray();


    }
}
