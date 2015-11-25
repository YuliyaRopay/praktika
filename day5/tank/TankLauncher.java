package day5.tank;

public class TankLauncher {
    public static void main(String[] args) {
        Tank tankBt7=new TankBT7();
        Tank tankT34=new TankT34();
        Tank tankTiger=new TankTiger();

        tankBt7.printTankInfo();
        tankT34.printTankInfo();
        tankTiger.printTankInfo();

        System.out.println();
        System.out.println(tankBt7);
        System.out.println(tankT34);
        System.out.println(tankTiger);

        System.out.println();
        tankBt7.move();
        tankT34.move();
        tankTiger.move();

    }
}
