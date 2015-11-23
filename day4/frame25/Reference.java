package day4.frame25;

public class Reference {
    private String name;
    private Reference reference;

    public Reference(String name){
        this.name=name;
    }

    public Reference(String name, Reference reference){
        this.name=name;
        this.reference=reference;
    }

    public String getName() {
        return name;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public void print() {
        System.out.println("Reference [name=" + name + ", reference=" + reference.getName() + "]");
    }

}
