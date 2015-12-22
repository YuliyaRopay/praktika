package tanks6.bf.tanks;

import tanks6.Direction;
import tanks6.bf.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class BT7 extends AbstractTank{

    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }

    @Override
    public Action setUp() {

        return destroyEagle();
     }



    //
    private Action destroyEagle(){

        int resultH=bf.getBFObjectLocation("E")[1];
        int resultV=bf.getBFObjectLocation("E")[0];

        int h=bf.getQuadrant(getX());
        int v=bf.getQuadrant(getY());


        if (resultH > h && getAction(v,h+1)!=Action.NONE){
            turn(Direction.RIGHT);
            //System.out.println(bf.scanQuadrant(v,h+1)+" R "+v+" "+(h+1));
            return getAction(v,h+1);
        }
        if (resultH < h && getAction(v,h-1)!=Action.NONE){
            turn(Direction.LEFT);
            //System.out.println(bf.scanQuadrant(v,h-1)+" L");
            return getAction(v,h-1);
        }
        if (resultV > v) {
             turn(Direction.BOTTOM);
            //System.out.println(bf.scanQuadrant(v+1,h)+" B");
            return getAction(v+1,h);
        }
        if (resultV < v && getAction(v-1,h)!=Action.NONE) {
            turn(Direction.TOP);
            //System.out.println(bf.scanQuadrant(v-1,h)+" T");
            return getAction(v-1,h);
        }

        return Action.NONE;
    }



}
