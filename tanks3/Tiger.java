package tanks3;

import java.awt.*;

public class Tiger extends AbstractTank {

    private int armor=1;

    public Tiger(ActionField af, BattleField bf){
        super(af, bf);
        tankColor=new Color(255,0,0);
        towerColor=new Color(0,255,0);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction){
        super(af, bf, x, y, direction);
        tankColor=new Color(255,0,0);
        towerColor=new Color(0,255,0);
    }

    @Override
    public void destroy() {

        if(armor>0){
            armor=0;
        }
        else {
            super.destroy();
        }
    }

}
