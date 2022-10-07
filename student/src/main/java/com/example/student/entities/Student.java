package com.example.student.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
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
        M, F
    }
    public enum passStatus {
        FAIL,
        THIRD_DIVSION,
        SECOND_DIVSION,
        FIRST_DIVISION
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(String passStatus) {
        this.passStatus = passStatus;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getYearOfStudying() {
        return yearOfStudying;
    }

    public void setYearOfStudying(int yearOfStudying) {
        this.yearOfStudying = yearOfStudying;
    }
}
