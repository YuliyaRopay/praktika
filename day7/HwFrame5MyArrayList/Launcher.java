package day7.HwFrame5MyArrayList;


public class Launcher {
    public static void main(String[] args) {

        SimpleArrayList arrayList=new SimpleArrayList();

        System.out.println(">>> Add:");
        arrayList.add("one");
        System.out.println(arrayList.toString());
        arrayList.add(2);
        System.out.println(arrayList.toString());
        arrayList.add(0.5);
        arrayList.add(0.5);
        System.out.println(arrayList.toString());
        arrayList.add(null);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Add first:");
        arrayList.addFirst("first");
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Add after index=3:");
        arrayList.addAfter(100, 3);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Remove object=5:");
        arrayList.remove(5);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Remove object=null:");
        arrayList.remove(null);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Remove object=0.5:");
        arrayList.remove(0.5);
        System.out.println(arrayList.toString());


        System.out.println();
        System.out.println(">>> For each:");
        for(Object o:arrayList){
            System.out.println(o.toString());
        }
    }
}
