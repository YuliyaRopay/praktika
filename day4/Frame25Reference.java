package day4;

public class Frame25Reference {
    private String name;
    private Frame25Reference reference;

    public Frame25Reference(String name){
        this.name=name;
    }

    public Frame25Reference(String name, Frame25Reference reference){
        this.name=name;
        this.reference=reference;
    }

    public String getName() {
        return name;
    }

    public Frame25Reference getReference() {
        return reference;
    }

    public void setReference(Frame25Reference reference) {
        this.reference = reference;
    }

    public void print() {
        System.out.println("Reference [name=" + name + ", reference=" + reference.getName() + "]");
    }

}
