package day8.HwBirds;

import java.util.Comparator;

public class BirdsByNameComparator implements Comparator<Bird> {
    @Override
    public int compare(Bird bird1, Bird bird2) {
        return bird1.getName().compareToIgnoreCase(bird2.getName());
    }
}
