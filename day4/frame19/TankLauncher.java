package day4.frame19;

public class TankLauncher {
    public static void main(String[] args) {
        Tank tank=new Tank();
        tank.color="red";
        tank.crew=3;
        tank.maxSpeed=60;
        tank.printTankInfo();

        Tank[] tanks= new Tank[5];
        tanks[0]=new Tank("white",5,100);
        tanks[1]=new Tank("green",2,60);
        tanks[2]=new Tank("red",3,50);
        tanks[3]=new Tank("blue",6,100);
        tanks[4]=new Tank("black",1,80);

        printTankInfo(tanks);
    }

    public static void printTankInfo(Tank[] tanks){
        for(Tank tank : tanks){
            tank.printTankInfo();
        }
    }
}
