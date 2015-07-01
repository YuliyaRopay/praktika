package tanks;

/**
 * Created by julia on 24.06.2015.
 */
public class BT7 extends Tank {

    public BT7(ActionField af, BattleField bf){
        super(af, bf);
        speed = 20;
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction){
        super(af, bf, x, y, direction);
        speed = 20;
    }

}
