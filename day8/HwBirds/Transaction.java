package day8.HwBirds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Transaction {

    private Calendar calendar;
    private Customer customer;
    private Bird bird;
    private int count;
    private double price;

    public Transaction(Calendar calendar, Customer customer, Bird bird, int count, double price) {
        this.calendar = calendar;
        this.customer = customer;
        this.bird = bird;
        this.count = count;
        this.price = price;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY.MM.dd hh:mm");
        /*
        return "["+calendar.get(Calendar.YEAR)+":"+calendar.get(Calendar.MONTH)+":"+calendar.get(Calendar.DATE)+
        ", "+(customer.getFirstName()!=null ? customer.getFirstName():"")+" "+
                (customer.getLastName()!=null ? customer.getLastName():"")+", "+
                bird.getName()+", "+count+", "+price;
                */
        return "["+dateFormat.format(calendar.getTime())+
                ", "+(customer.getFirstName()!=null ? customer.getFirstName():"")+" "+
                (customer.getLastName()!=null ? customer.getLastName():"")+", "+
                bird.getName()+", "+count+", "+price+"]";
    }
}
