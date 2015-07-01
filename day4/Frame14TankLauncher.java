package day4;

public class Frame14TankLauncher {
    public static void main(String[] args) {
        Frame14Tank tank=new Frame14Tank();
        tank.color="red";
        tank.crew=3;
        tank.maxSpeed=60;
        tank.printTankInfo();

        Frame14Tank[] tanks= new Frame14Tank[5];
        tanks[0]=new Frame14Tank("white",5,100);
        tanks[1]=new Frame14Tank("green",2,60);
        tanks[2]=new Frame14Tank("red",3,50);
        tanks[3]=new Frame14Tank("blue",6,100);
        tanks[4]=new Frame14Tank("black",1,80);

        printTankInfo(tanks);
    }

    public static void printTankInfo(Frame14Tank[] tanks){
        for(Frame14Tank tank : tanks){
            tank.printTankInfo();
        }
    }
}
