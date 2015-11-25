package day5.tank;

public class TankT34 extends Tank {
    public TankT34(){
        this("green", 6, 50);
    }

    public TankT34(String color, int crew, int maxSpeed){
        super(color,crew,maxSpeed);
    }


    @Override
    public String toString() {
        return "Tank Tiger:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
