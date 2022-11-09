package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
//@ComponentScan({"com.example.demo.student.StudentService"})
public class StudentController {
   private final StudentService studentService;

   @Autowired
   private StudentRepository studentRepository;

   @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students")
    public List<Student> getStudents(){
       return studentRepository.findAll();
//       return studentService.getStudents();
    }

    @GetMapping( "/{id}/{name}")
    public Student getStudentById(@PathVariable Integer id){
//       Student student = studentService.getStudentById(id);
//       if(student == null){
//           throw new UserNotFoundException("id-" + id);
//       }
////        EntityModel<Student> resource = EntityModel.of(student)
//       return new ArrayList<>();
        Optional<Student> student = studentRepository.findById((long) id);
        return student.get();
    }

    @PostMapping(path = "/students")
    public ResponseEntity saveStudentDetails(@Valid @RequestBody Student student){
//       Getting student details using @RequestBody and saving it
//       Student newStudent = studentService.saveStudentDetails(student);
//       Constructing the URI for the given student instance
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/students/{id}").buildAndExpand(newStudent.getId()).toUri();
//        returning a created status as response
//        return ResponseEntity.created(location).build();
//        return ResponseEntity.ok(newStudent);
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudentDetails(@PathVariable Integer id){
//       System.out.println("Inside method");
//       Student student = studentService.deleteStudentDetails(id);
//       if(student == null){
//           throw new UserNotFoundException("id-"+id);
//       }
//       return new ResponseEntity(HttpStatus.ACCEPTED);
        studentRepository.deleteById((long) id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student details deleted");
    }
}
