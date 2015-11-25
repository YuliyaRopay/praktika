package day5.tank;

public class TankBT7 extends Tank {
    public TankBT7(){
        this("white", 3, 72);
    }

    public TankBT7(String color, int crew, int maxSpeed){
        super(color,crew,maxSpeed);
    }

    @Override
    public String toString() {
        return "Tank BT7:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
