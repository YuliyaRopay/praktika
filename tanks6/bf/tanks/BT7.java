package tanks6.bf.tanks;

import tanks6.Direction;
import tanks6.bf.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BT7 extends AbstractTank{

    public BT7(BattleField bf) {
        this(bf,128,512,Direction.TOP);
    }

    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 1;

        tankBottomImg=setImage(BFImages.IMG_BT7_BOTTOM);
        tankTopImg=setImage(BFImages.IMG_BT7_TOP);
        tankLeftImg=setImage(BFImages.IMG_BT7_LEFT);
        tankRightImg=setImage(BFImages.IMG_BT7_RIGHT);
    }
    @Override
    public Action setUp() {

        return destroyEagle2();
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
        if (resultV > v && getAction(v+1,h)!=Action.NONE) {
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



    // horizontal move
    private char flagMove='h';

     //
    private Action destroyEagle2(){

        int resultH=bf.getBFObjectLocation("E")[1];
        int resultV=bf.getBFObjectLocation("E")[0];

        int h=bf.getQuadrant(getX());
        int v=bf.getQuadrant(getY());
        int tmpH=h;
        int tmpV=v;

        Direction newDirection=Direction.NONE;

        if(flagMove=='h'){
            if (resultH > h){
                h=h+1;
                newDirection=Direction.RIGHT;
            }
            else if (resultH < h){
                h=h-1;
                newDirection=Direction.LEFT;
            }

            else if (resultV > v) {
                v=v+1;
                newDirection=Direction.BOTTOM;
            }
            else if (resultV < v) {
                v=v-1;
                newDirection=Direction.TOP;
            }
        }
        else{
            if (resultV > v) {
                v=v+1;
                newDirection=Direction.BOTTOM;
            }
            else if (resultV < v) {
                v=v-1;
                newDirection=Direction.TOP;
            }
            else if (resultH > h){
                h=h+1;
                newDirection=Direction.RIGHT;
            }
            else if (resultH < h){
                h=h-1;
                newDirection=Direction.LEFT;
            }

        }



        System.out.println("v="+v+" h="+h+" "+newDirection );
        if(getAction(v,h)!=Action.NONE){
            turn(newDirection);
            return getAction(v,h);
        }
        else{


           if(newDirection.equals(Direction.BOTTOM) || newDirection.equals(Direction.TOP)) {
               for (int i=tmpH+1; i<bf.QUADRANT_COUNT_X; i++){
                   if(getAction(tmpV,i)!=Action.NONE){
                       newDirection=Direction.RIGHT;
                       tmpH=i;
                       flagMove='v';
                       break;

                   }
               }

           }
            else{
               for (int i=tmpV+1; i<bf.QUADRANT_COUNT_Y; i++){
                   if(getAction(i,tmpH)!=Action.NONE){
                       newDirection=Direction.BOTTOM;
                       tmpV=i;
                       flagMove='h';
                       break;
                   }
               }
           }

            System.out.println("Tv="+tmpV+" Th="+tmpH+" " );
            turn(newDirection);
            return getAction(tmpV,tmpH);

        }


       // return Action.NONE;
    }


}
