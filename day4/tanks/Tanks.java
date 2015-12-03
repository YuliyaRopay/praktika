package day4.tanks;

import javax.swing.*;


public class Tanks extends JPanel {

    //0-no fire, 1-fire
    int flagFire=0;

/*

    //set the flagFire
    public void setFire(int fire){
        flagFire=fire;
    }


    // moveToQuadrant(y, x)
    public void moveToQuadrant(int v, int h) throws Exception {
        String quadrant = getQuadrant(v, h);

        int resultX = Integer.parseInt(quadrant.substring(0,
                quadrant.indexOf("_")));
        int resultY = Integer
                .parseInt(quadrant.substring(quadrant.indexOf("_") + 1));

        while (resultX != tankX) {
            if (resultX > tankX) {
                runAndFire(4);
            } else {
                runAndFire(3);
            }
        }

        while (resultY != tankY) {
            if (resultY > tankY) {
                runAndFire(2);
            } else {
                runAndFire(1);
            }
        }
    }


   //
    public void fire() throws Exception {
        bulletX = tankX + 25;
        bulletY = tankY + 25;
        int step = 1;

        while (bulletX > -15 && bulletX < BF_WIDTH && bulletY > -15 && bulletY < BF_HEIGHT) {
            //System.out.println(bulletX + "----" + bulletY);

            if (tankDirection == 1) {
                bulletY -= step;
            } else if (tankDirection == 2) {
                bulletY += step;
            } else if (tankDirection == 3) {
                bulletX -= step;
            } else {
                bulletX += step;
            }

            if (processInterception() == true) {
                bulletX = -100;
                bulletY = -100;
            }

            repaint();
            Thread.sleep(bulletSpeed);
        }
    }



    //flagFire = 0/1  no fire/fire
    public void runAndFire(int direction) throws Exception {

        int x=tankX/QUADRANT_SIZE;
        int y=tankY/QUADRANT_SIZE;

        int nextX=x;
        int nextY=y;

        if(direction==1){
            nextY-=1;
        }else if(direction==2){
            nextY+=1;
        }else if(direction==3){
            nextX-=1;
        }else if(direction==4){
            nextX+=1;
        }

        turn(direction);
        repaint();

        int i = 0;
        if(flagFire==1 && isElementOnQuadrant(nextY, nextX, "B")){
            System.out.println("nextX="+nextX+"  nextY="+nextY +"  fire");
            Thread.sleep(20);
            while (i <= 1) {
                fire();
                i++;
            }
        }

        move(direction);

    }


    //
    public boolean isElementOnQuadrant(int y, int x, String element){

        if(y>=0 && y<QUADRANT_COUNT_Y && x>=0 && x<QUADRANT_COUNT_X
                && battleField[y][x].equalsIgnoreCase(element)){
            System.out.println("x="+x+"  y="+y +"  element="+element);
            return true;
        }
        return false;
    }


    //
    public void cleanRandom() throws Exception {
        setFire(1);

        Random r=new Random();
        int randomX;
        int randomY;

        while(true){
            randomX=r.nextInt(9)+1;
            randomY=r.nextInt(9)+1;
            moveToQuadrant(randomY,randomX);
        }
    }


    //
    public void clean() throws Exception {

        turn(4);
        setFire(1);

        for (int i = 1; i <= QUADRANT_COUNT_X; i++) {
            if (i % 2 == 0) {
                moveToQuadrant(1, i);
            }
            else {
                for (int j = 1; j <= QUADRANT_COUNT_Y; j++) {
                    moveToQuadrant(j, i);
                }
            }
        }
    }

*/
}