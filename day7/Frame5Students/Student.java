package day7.Frame5Students;


public class Student {
    private String name;
    private String secondName;

    public Student(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student s =(Student) obj;
            if(name!=null && name.equals(s.getName())
                    && secondName!=null && secondName.equals(s.getSecondName())){
                return true;
            }
        }
        return false;

    }
}
