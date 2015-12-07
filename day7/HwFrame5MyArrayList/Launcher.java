package day7.HwFrame5MyArrayList;


public class Launcher {
    public static void main(String[] args) {

        SimpleArrayList arrayList=new SimpleArrayList();

        System.out.println(">>> Add last:");
        arrayList.addLast("one");
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Add last:");
        arrayList.addLast(2);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Add last:");
        arrayList.addLast(0.5);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> Add last:");
        arrayList.addLast(null);
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
        System.out.println(">>> Remove index=5:");
        arrayList.remove(5);
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println(">>> For each:");
        for(Object o:arrayList){
            System.out.println(o.toString());
        }
    }
}
