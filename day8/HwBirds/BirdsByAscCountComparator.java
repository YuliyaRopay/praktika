package day8.HwBirds;


import java.util.Comparator;

public class BirdsByAscCountComparator implements Comparator<Bird> {
    @Override
    public int compare(Bird bird1, Bird bird2) {
        int count1=bird1.getCount();
        int count2=bird2.getCount();
        if(count1>count2){
            return 1;
        }
        else if(count1<count2){
            return -1;
        }
        return 0;
    }
}
