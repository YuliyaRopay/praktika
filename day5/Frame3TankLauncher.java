package day5;

/**
 * Created by julia on 21.06.2015.
 */
public class Frame3TankLauncher {
    public static void main(String[] args) {
        Frame3Tank tankBt7=new Frame3TankBT7();
        Frame3Tank tankT34=new Frame3TankT34();
        Frame3Tank tankTiger=new Frame3TankTiger();

        tankBt7.printTankInfo();
        tankT34.printTankInfo();
        tankTiger.printTankInfo();

    }
}
