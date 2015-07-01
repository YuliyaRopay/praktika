package day5;

public class Frame3TankTiger extends Frame3Tank{

    private int armor;
    public Frame3TankTiger(){
        this("black", 2, 36);
    }

    public Frame3TankTiger(String color, int crew, int maxSpeed){
        super(color,crew,maxSpeed);
        this.armor=1;
    }

    @Override
    public String toString() {
        return "Tank T34:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
