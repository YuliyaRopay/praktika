package tanks6.bf.tanks;

import tanks6.Direction;
import tanks6.bf.BattleField;

import java.awt.*;

public class T34 extends AbstractTank{

    public T34( BattleField bf) {
        super( bf,  128, 512, Direction.TOP);
        tankColor=new Color(0,255,0);
        towerColor=new Color(255,0,0);
    }

    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor=new Color(0,255,0);
        towerColor=new Color(255,0,0);
    }

    private Object[] actoins = new Object[] {
            Direction.RIGHT,
            Action.FIRE,
            Action.MOVE,
            Direction.RIGHT,
            Action.FIRE,
            Action.MOVE,
            Direction.TOP,
            Action.FIRE,
            Action.MOVE,
            Direction.LEFT,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Direction.TOP,
            Action.FIRE,
            Action.MOVE,
            Direction.LEFT,
            Action.FIRE,
            Action.MOVE,
            Direction.BOTTOM,
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
