package day5;

public class Frame3TankBT7 extends Frame3Tank{
    public Frame3TankBT7(){
        this("white", 3, 72);
    }

    public Frame3TankBT7(String color, int crew, int maxSpeed){
        super(color,crew,maxSpeed);
    }

    @Override
    public String toString() {
        return "Tank BT7:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
