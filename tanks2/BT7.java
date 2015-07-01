package tanks2;

import java.awt.*;

public class BT7 extends AbstractTank {

    public BT7(ActionField af, BattleField bf){
        super(af, bf);
        tankColor=new Color(255,0,0);
        towerColor=new Color(0,255,0);
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction){
        super(af, bf, x, y, direction);
        tankColor=new Color(255,0,0);
        towerColor=new Color(0,255,0);
    }

}
