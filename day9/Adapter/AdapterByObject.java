package day9.Adapter;

public class AdapterByObject implements Target {

    private Adaptee adaptee;

    public AdapterByObject(){
        adaptee=new Adaptee();
    }

    @Override
    public String newRequest() {
        return adaptee.oldRequest();
    }
}
