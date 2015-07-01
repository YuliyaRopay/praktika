package day4.tanks;

public class BattleField {

    private int bfWidth = 576;
    private int bfHeight = 576;

    private String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {"B", " ", " ", "B", " ", "B", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", " ", " ", " ", " ", " ", "B", "B", "B"},
            {" ", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", " ", "B"},
            {"B", "B", " ", " ", " ", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };


    public BattleField() {
    }

    public BattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    public int getBfWidth() {
        return bfWidth;
    }

    public int getBfHeight() {
        return bfHeight;
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

}
