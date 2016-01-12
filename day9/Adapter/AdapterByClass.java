package day9.Adapter;

public class AdapterByClass extends Adaptee implements Target {

    @Override
    public String newRequest() {
        return oldRequest();
    }
}
