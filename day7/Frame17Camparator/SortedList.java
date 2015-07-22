package day7.Frame17Camparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedList {
    public static void main(String[] args) {
        List<String> stringList=new ArrayList<String>();
        stringList.add("Petrov Oleg");
        stringList.add("Ivanov Pasha");
        stringList.add("Petrov Alex");
        stringList.add("Sidorov Dima");
        stringList.add("Petrov Andrey");

        Collections.sort(stringList);

        for(String str:stringList){
            System.out.println(str);
        }

        System.out.println();
        Collections.sort(stringList, new StringZAComparator());

        for(String str:stringList){
            System.out.println(str);
        }

        //
        System.out.println();
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result=o1.compareToIgnoreCase(o2);
                if(result<0){
                    return 1;
                }
                else if(result>0){
                    return -1;
                }
                return 0;
            }
        });

        for(String str:stringList){
            System.out.println(str);
        }

    }
}
