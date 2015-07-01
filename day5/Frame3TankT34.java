package day5;

public class Frame3TankT34 extends Frame3Tank {
    public Frame3TankT34(){
        this("green", 6, 50);
    }

    public Frame3TankT34(String color, int crew, int maxSpeed){
        super(color,crew,maxSpeed);
    }


    @Override
    public String toString() {
        return "Tank Tiger:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
