package com.example.student.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "studentNumber")
    private int studentNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "passStatus")
    private String passStatus;
    @Column(name = "totalMarks")
    private int totalMarks;
    @Column(name = "yearOfStudying")
    private int yearOfStudying;

    public enum gender {
        M, F;
    }
    public enum yearOfStudying {
        FIRST, SECOND, THIRD, FOURTH;
    }

    public Student() {

    }

    public Student(String id, int studentNumber, String name, String gender, String passStatus, int totalMarks, int yearOfStudying) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.gender = gender;
        this.passStatus = passStatus;
        this.totalMarks = totalMarks;
        this.yearOfStudying = yearOfStudying;
    }
}
