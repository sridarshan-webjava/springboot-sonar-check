package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {
    private static List<Student> students = new ArrayList<>();

    private static Long studentCount = 3L;

    static {
        students.add(new Student("Sri",9098765432L,"sri@xyz.com"));
        students.add(new Student("Mark", 8769873214L,"mark@xyz.com"));
        students.add(new Student("Adam",6783241546L,"adam@xyz.com"));
    }
////    private final StudentRepository studentRepository;
//
//    @Autowired
////    public StudentService(StudentRepository studentRepository) {
////        this.studentRepository = studentRepository;
////    }

    public List<Student> getStudents(){
        return students;
    }

    public Student getStudentById(Long id){
        for(Student student:students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public Student saveStudentDetails(Student student){
        if(student.getId() == null){
            student.setId(++studentCount);
        }
        students.add(student);
        return student;
    }

    public Student deleteStudentDetails(Long id){
        System.out.println("Method is called");
        Iterator iterator = students.iterator();
        while(iterator.hasNext()){
            Student student = (Student)iterator.next();
            if(student.getId() == id){
                iterator.remove();
                return student;
            }
        }
        return null;
    }
}
