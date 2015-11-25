package day5.tank;

public class TankLauncher {
    public static void main(String[] args) {
        Tank tankBt7=new TankBT7();
        Tank tankT34=new TankT34();
        Tank tankTiger=new TankTiger();

        tankBt7.printTankInfo();
        tankT34.printTankInfo();
        tankTiger.printTankInfo();

    }
}
