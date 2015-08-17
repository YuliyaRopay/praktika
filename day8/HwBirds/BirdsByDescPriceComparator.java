package day8.HwBirds;


import java.util.Comparator;

public class BirdsByDescPriceComparator implements Comparator<Bird>{
    @Override
    public int compare(Bird bird1, Bird bird2) {
        double price1=bird1.getPrice();
        double price2=bird2.getPrice();
         if(price1<price2){
            return 1;
        }
        else if(price1>price2){
            return -1;
        }
        return 0;
    }
}
