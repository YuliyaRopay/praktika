package day4;

public class HwFrame4Car {
    private HwFrame3Color color;

    private String name;
    private String number;

    private int doorCount;
    private int maxSpeed;

    private boolean isMoving;



    public HwFrame4Car(HwFrame3Color color, String name, String number, int doorCount,
               int maxSpeed, boolean isMoving) {
        this.color = color;
        this.name = name;
        this.number = number;
        this.doorCount = doorCount;
        this.maxSpeed = maxSpeed;
        this.isMoving = isMoving;
    }

    public HwFrame3Color getColor() {
        return color;
    }

    public void setColor(HwFrame3Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

}
