package tanks2;

/**
 * Created by julia on 24.06.2015.
 */
public class Tiger extends TankOld {

    private int armor=1;

    public Tiger(ActionField af, BattleField bf){
        super(af, bf);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction){
        super(af, bf, x, y, direction);
    }


}
