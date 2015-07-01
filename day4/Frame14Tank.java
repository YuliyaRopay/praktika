package day4;

public class Frame14Tank {
    String color;
    int crew;
    int maxSpeed;

    public Frame14Tank(){
        this("red",6,200);
    }

    public Frame14Tank(String color, int crew, int maxSpeed) {
        this.color = color;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
    }


    public void printTankInfo(){
        System.out.println("Tank info:["+color+" : "+crew+" : "+maxSpeed+"]");
    }
}
