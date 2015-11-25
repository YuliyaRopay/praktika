package day5.tank;

public class TankTiger extends Tank {

    private int armor;
    public TankTiger(){
        this("black", 2, 36);
    }

    public TankTiger(String color, int crew, int maxSpeed){
        super(color,crew,maxSpeed);
        this.armor=1;
    }

    @Override
    public String toString() {
        return "Tank T34:["+color+" : "+crew+" : "+maxSpeed+"]";
    }
}
