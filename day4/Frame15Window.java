package day4;

public class Frame15Window {
    String room;
    String material;
    String color;
    char side;
    boolean isOpen;
    boolean isVentilation;

    public Frame15Window() {
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getSide() {
        return side;
    }

    public void setSide(char side) {
        this.side = side;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isVentilation() {
        return isVentilation;
    }

    public void setVentilation(boolean isVentilation) {
        this.isVentilation = isVentilation;
    }

    public void printAllInfo(){}
}
