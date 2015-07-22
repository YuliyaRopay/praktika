package tanks4Refactoring.bf.tanks;

import tanks4Refactoring.ActionField;
import tanks4Refactoring.Direction;
import tanks4Refactoring.bf.BattleField;
import tanks4Refactoring.bf.tanks.AbstractTank;

import java.awt.*;

public class T34 extends AbstractTank {

    public T34( BattleField bf) {
        super( bf,  128, 512, Direction.Bottom);
        tankColor=new Color(0,255,0);
        towerColor=new Color(255,0,0);
    }

    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor=new Color(0,255,0);
        towerColor=new Color(255,0,0);
    }

    private Object[] actoins = new Object[] {
            Direction.Right,
            Action.FIRE,
            Action.MOVE,
            Direction.Top,
            Action.FIRE,
            Action.MOVE,
            Direction.Left,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Direction.Top,
            Action.FIRE,
            Action.MOVE,
            Direction.Left,
            Action.FIRE,
            Action.MOVE,
            Direction.Bottom,
            Action.FIRE,
            Action.MOVE
    };

    private int step = 0;

    @Override
    public Action setUp() {
        if (step >= actoins.length) {
            step = 0;
        }
        if (!(actoins[step] instanceof Action)) {
            turn((Direction) actoins[step++]);
        }
        if (step >= actoins.length) {
            step = 0;
        }
        return (Action) actoins[step++];
    }
}
