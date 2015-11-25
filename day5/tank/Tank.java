package day5.tank;

public class Tank {
    String color;
    int crew;
    int maxSpeed;

    public Tank(){
        this("red",6,200);
    }

    public Tank(String color, int crew, int maxSpeed) {
        this.color = color;
        this.crew = crew;
        this.maxSpeed = maxSpeed;
    }

    public void move(){
        System.out.println("Tank is moving");
    }

    public void printTankInfo(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Tank info:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
