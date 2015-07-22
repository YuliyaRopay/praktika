package tanks3;


public class BT7 extends AbstractTank {

    public BT7(ActionField af, BattleField bf){
        super(af, bf);
        speed = 20;
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction){
        super(af, bf, x, y, direction);
        speed = 20;
    }

}
