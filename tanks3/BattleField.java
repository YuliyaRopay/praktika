package tanks3;

import java.util.Random;

public class BattleField {

    private final int QUADRANT_SIZE=64;

    private final int QUADRANT_COUNT_X=9;
    private final int QUADRANT_COUNT_Y=9;

    //final int BF_WIDTH = 576;
    //final int BF_HEIGHT = 576;
    private final int BF_WIDTH = QUADRANT_SIZE*QUADRANT_COUNT_X;
    private final int BF_HEIGHT = QUADRANT_SIZE*QUADRANT_COUNT_Y;

    private String[][] battleField = {
            {" ", "B", "B", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", "B", " ", "B", " ", " ", "B"},
            {" ", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", " ", " ", " ", " ", " ", "B", "B", "B"},
            {" ", "B", "B", " ", "B", " ", "B", "B", "B"},
            {" ", "B", " ", "B", "B", "B", " ", " ", "B"},
            {"B", "B", " ", " ", " ", " ", "B", "B", "B"},
            {" ", "B", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    public BattleField() {
    }

    public BattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    //!!!!!!!!!!!!!! заменить константами
    public int getBfWidth() {
        return BF_WIDTH;
    }

    public int getBfHeight() {
        return BF_HEIGHT;
    }

    public String[][] getBattleField() {
        return battleField;
    }

    public int getDimentionX(){
        return battleField.length;
    }

    public int getDimentionY(){
        return battleField.length;
    }

    public void updateQuadrant(int v,int h,String object){
        this.battleField[v][h]=object;
    }

    public 	String scanQuadrant(int v,int h){
        return battleField[v][h];
    }

    public String getAggressorLocation(){
        /*
               this.tank=tank;
        Random r=new Random();
        int i;
        while(true){
            i=r.nextInt(4)+1;
            // 1 - top, 2 - bottom, 3 - left, 4 - right
            tank.turn(Direction.values()[i]);
            tank.move();
            //runAndFire(i);
            Thread.sleep(tank.getSpeed());
        }
         */

        String[] aggressorPosition=new String[]{"64_64",64*3+"_"+64*5,0+"_"+0};
        Random r=new Random();
        int i=r.nextInt(3);

        return aggressorPosition[i];
    }

}
