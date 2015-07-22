package tanks4Refactoring.bf.tanks;


import tanks4Refactoring.Direction;
import tanks4Refactoring.bf.BattleField;

import java.awt.*;

public class BT7 extends AbstractTank {

    public BT7(BattleField bf){
        //speed = 20;

        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }

    public BT7(BattleField bf, int x, int y, Direction direction){
        //speed = 20;
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }


    @Override
    public Action setUp() {
        return Action.MOVE;
    }

}
