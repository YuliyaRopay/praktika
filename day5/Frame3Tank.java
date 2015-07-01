package day5;

/**
 * Created by julia on 21.06.2015.
 */
public class Frame3Tank {
    String color;
    int crew;
    int maxSpeed;

    public Frame3Tank(){
        this("red",6,200);
    }

    public Frame3Tank(String color, int crew, int maxSpeed) {
        this.color = color;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
    }


    public void printTankInfo(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Tank info:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
