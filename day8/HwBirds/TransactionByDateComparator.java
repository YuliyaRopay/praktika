package day8.HwBirds;


import java.util.Calendar;
import java.util.Comparator;

public class TransactionByDateComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction tr1, Transaction tr2) {
        Calendar c1=tr1.getCalendar();
        Calendar c2=tr2.getCalendar();
        if(c1.compareTo(c2)<0){
            return 1;
        }else if(c1.compareTo(c2)>0){
            return -1;
        }
        return 0;
    }
}
