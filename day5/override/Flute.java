package day5.override;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Flute extends Instrument {

    public String name;

    public Flute(){

    }

    @Override
    public void playMusic() {
        System.out.println("Flute is playing....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
