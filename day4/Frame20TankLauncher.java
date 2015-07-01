package day4;

public class Frame20TankLauncher {
    public static void main(String[] args) {
        Frame20Tank tank=new Frame20Tank();
        tank.color="red";
        tank.crew=3;
        tank.maxSpeed=60;
        tank.printTankInfo();

        Frame20Tank[] tanks= new Frame20Tank[5];
        tanks[0]=new Frame20Tank("white",5,100);
        tanks[1]=new Frame20Tank("green",2,60);
        tanks[2]=new Frame20Tank("red",3,50);
        tanks[3]=new Frame20Tank("blue",6,100);
        tanks[4]=new Frame20Tank("black",1,80);

        printTankInfo(tanks);
    }

    public static void printTankInfo(Frame20Tank[] tanks){
        for(Frame20Tank tank : tanks){
            tank.printTankInfo();
        }
    }
}
