package day6.HwCafe;


public class Ingredient {

    private String name;
    private int count;
    private String measure;
    private double price;

    public Ingredient(String name, double price) {
       this(name,price,0,"not");
    }

    public Ingredient(String name, double price, int count, String measure) {
        this.name = name;
        this.count = count;
        this.measure = measure;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "["+name+": "+count+measure+" ="+price+"]";
    }
}
