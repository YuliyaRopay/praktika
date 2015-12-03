package day4.tanks;

public class Tiger extends Tank {

    private int armor=1;

    public Tiger(ActionField af, BattleField bf){
        super(af, bf);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction){
        super(af, bf, x, y, direction);
    }


}
