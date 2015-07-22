package day7.Frame17Camparator;


import java.util.Comparator;

public class StringZAComparator implements Comparator<String>{
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
}
