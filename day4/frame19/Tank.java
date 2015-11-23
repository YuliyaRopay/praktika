package day4.frame19;

public class Tank {
    String color;
    int crew;
    int maxSpeed;

    public Tank(){
        this("red",6,200);
    }

    public Tank(String color){
        this(color,0,0);
    }

    public Tank(String color, int crew, int maxSpeed) {
        this.color = color;
        this.crew = crew;
        setMaxSpeed(maxSpeed);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if(maxSpeed>200){
            this.maxSpeed = 200;
        }
        else{
            this.maxSpeed = maxSpeed;
        }
    }

    public void printTankInfo(){
        System.out.println("Tank info:["+color+" : "+crew+" : "+maxSpeed+"]");
    }

}
