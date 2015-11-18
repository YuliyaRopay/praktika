package day8.HwBirds;


import java.util.Comparator;

public class Bird {

    private String name;
    private double price;
    private BirdsType type;

    private int count;
    private int sold;


    public Bird(String name) {
        this(name, BirdsType.NONE, 0, 0);
    }

    public Bird(String name, double price) {
        this(name, BirdsType.NONE, 0, price);
    }

    public Bird(String name, BirdsType type, double price) {
        this(name, type, 0, price);
    }

    public Bird(String name, BirdsType type, int count, double price) {
        this(name, type, count, price,0);
    }

    public Bird(String name, BirdsType type, int count, double price, int sold) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.count = count;
        this.sold = sold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BirdsType getType() {
        return type;
    }

    public void setType(BirdsType type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "["+name+" "+type+",  count:"+count+" price:"+price+" sold:"+sold+"]";
    }


}
