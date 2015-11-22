package day4.frame15;

import java.util.Date;

public class Flower {
    String name;
    String classFlower;
    String color;
    String description;
    Date landingDate;
    Date woteringDate;
    int height;
    int count;

    public Flower() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassFlower() {
        return classFlower;
    }

    public void setClassFlower(String classFlower) {
        this.classFlower = classFlower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(Date landingDate) {
        this.landingDate = landingDate;
    }

    public Date getWoteringDate() {
        return woteringDate;
    }

    public void setWoteringDate(Date woteringDate) {
        this.woteringDate = woteringDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHeightAbove(int height){
        return false;
    }

    public Date ageFlower(){
        return null;
    }

    public int countDayWithoutWatering(){
        return 0;
    }

    public void printAllInfo(){}
}
