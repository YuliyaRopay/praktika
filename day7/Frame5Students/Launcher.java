package day7.Frame5Students;


import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {

        List<Student> studentList=new ArrayList<Student>();
        for(int i=0;i<10;i++){
            studentList.add(i,new Student("Name_"+i,"SecondName_"+i));
        }

        Classroom classroom=new Classroom(studentList);
        classroom.enter(new Student("Name_","SecondName_"));
        classroom.printStudentInfo();

        System.out.println(">>>");
        classroom.leave(studentList.get(5));
        classroom.printStudentInfo();

        System.out.println(">>>");
        System.out.println("count= "+classroom.getStudentCount());

        System.out.println(">>>");
        System.out.println(classroom.isPresent("Name_3","SecondName_3"));
        System.out.println(classroom.isPresent("Name_2","SecondName_1"));
     }
}
