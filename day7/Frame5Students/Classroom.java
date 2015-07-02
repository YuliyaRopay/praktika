package day7.Frame5Students;


import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<Student> students=new ArrayList<Student>();

    public Classroom(){

    }
    public Classroom(List<Student> students){
        this.students=students;
    }

    public void enter(Student student){
            students.add(students.size(),student);
    }

    public boolean leave(Student student){
        return students.remove(student);
    }

    public int getStudentCount(){
        return students.size();
    }

    public boolean isPresent(String name, String secondName){
        for(Student student: students){
            if(student.getName().equals(name)&& student.getSecondName().equals(secondName)){
                return true;
            }
        }
        return false;
    }

    public void printStudentInfo(){
        for(int i=0;i<students.size();i++){
            System.out.println(i+". "+students.get(i).getName()+"  "+students.get(i).getSecondName());
        }
    }

    public List<Student> getStudents(){
        return new ArrayList<Student>(students);
    }
}


