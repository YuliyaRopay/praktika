package tanks4Refactoring.bf;

import java.awt.*;
import java.util.Random;

public class BattleField implements Drawable{

    private final int QUADRANT_SIZE=64;

    private final int QUADRANT_COUNT_X=9;
    private final int QUADRANT_COUNT_Y=9;

    private final int BF_WIDTH = QUADRANT_SIZE*QUADRANT_COUNT_X;
    private final int BF_HEIGHT = QUADRANT_SIZE*QUADRANT_COUNT_Y;

    public static final String BRICK = "B";
    public static final String EAGLE = "E";
    public static final String ROCK = "R";
    public static final String WATER = "W";

    private String[][] battleFieldTemplate = {
            {" ", "W", "W", "B", "B", "B", "B", "B", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", "B"},
            {" ", "B", "B", " ", "B", " ", "B", "B", "R"},
            {"R", " ", " ", " ", " ", " ", "B", "B", "B"},
            {" ", "B", "B", " ", "B", " ", "B", "B", "B"},
            {" ", "B", " ", "B", "B", "B", " ", " ", "B"},
            {"W", "B", " ", " ", " ", " ", "B", "B", "B"},
            {" ", "B", " ", "B", "W", "E", " ", " ", "B"},
            {" ", " ", " ", "B", "B", " ", " ", " ", " "}
    };

    private BFObject[][] battleField = new BFObject[QUADRANT_COUNT_X][QUADRANT_COUNT_Y];

    public BattleField() {
        drawBattleField();
    }

    public BattleField(String[][] battleField) {
        this.battleFieldTemplate = battleField;
        drawBattleField();
    }

    //!!!!!!!!!!!!!! заменить константами
    public int getBfWidth() {
        return BF_WIDTH;
    }

    public int getBfHeight() {
        return BF_HEIGHT;
    }


    public String[][] getBattleFieldTemplate() {
        return battleFieldTemplate;
    }

    public int getDimentionX(){
        return battleField.length;
    }

    public int getDimentionY(){
        return battleField.length;
    }


    public void updateQuadrant(int v,int h,String object){
        this.battleFieldTemplate[v][h]=object;
    }


    public BFObject scanQuadrant(int v, int h) {
        return battleField[v][h];
    }

    public void destroyObject(int v, int h) {
        battleField[v][h].destroy();
    }

    private String getQuadrantXY(int v, int h) {
        return (v - 1) * QUADRANT_SIZE + "_" + (h - 1) * QUADRANT_SIZE;
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

    @Override
    public void draw(Graphics g) {
        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {
                battleField[j][k].draw(g);
            }
        }
    }


    private void drawBattleField() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String coordinates = getQuadrantXY(i + 1, j + 1);
                int separator = coordinates.indexOf("_");
                int y = Integer.parseInt(coordinates
                        .substring(0, separator));
                int x = Integer.parseInt(coordinates
                        .substring(separator + 1));

                String obj = battleFieldTemplate[i][j];
                BFObject bfObject;
                if (obj.equals(BRICK)) {
                    bfObject = new Brick(x, y);
                } else if (obj.equals(ROCK)) {
                    bfObject = new Rock(x, y);
                } else if (obj.equals(EAGLE)) {
                    bfObject = new Eagle(x, y);
                } else if (obj.equals(WATER)) {
                    bfObject = new Water(x, y);
                } else {
                    bfObject = new Blank(x, y);
                }
                battleField[i][j] = bfObject;
            }
        }
    }
}
