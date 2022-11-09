package com.example.demo.student;

//@Entity
//@Table
//public class Student {
//    @Id
//    @SequenceGenerator(
//            name="student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
//    private Long id;
//    private String name;
//    private LocalDate dob;
//    private Integer age;
//    private String email;
//
//    public Student() {
//    }
//
//    public Student(String name, LocalDate dob, int age, String email) {
//        this.name = name;
//        this.dob = dob;
//        this.age = age;
//        this.email = email;
//    }
//
//    public Student(long id, String name, LocalDate dob, int age, String email) {
//        this.id = id;
//        this.name = name;
//        this.dob = dob;
//        this.age = age;
//        this.email = email;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//}

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class Student{
    @Id
    @GeneratedValue
    private Long id;
    @Size(min=2,message="Size of name attribute should atleast be 2")
    private String name;
    private Long phno;
    private String email;

    public Student(){};

    public Student(String name, Long phno, String email) {
        this.name = name;
        this.phno = phno;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}