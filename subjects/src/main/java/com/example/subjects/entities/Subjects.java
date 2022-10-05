package com.example.subjects.entities;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subjects {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "studentNumber")
    private int studentNumber;
    @Column(name = "physicsoral")
    private int physicsoral;
    @Column(name = "chemistryoral")
    private int chemistryoral;
    @Column(name = "physicspractical")
    private int physicspractical;
    @Column(name = "chemistrypractical")
    private int chemistrypractical;
    @Column(name = "language")
    private int language;
    @Column(name = "maths")
    private int maths;
    @Column(name = "computersc")
    private int computersc;

    public Subjects() {
    }

    public Subjects(String id, int studentNumber, int physicsoral, int chemistryoral, int physicspractical, int chemistrypractical, int language, int maths, int computersc) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.physicsoral = physicsoral;
        this.chemistryoral = chemistryoral;
        this.physicspractical = physicspractical;
        this.chemistrypractical = chemistrypractical;
        this.language = language;
        this.maths = maths;
        this.computersc = computersc;
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

    public int getPhysicsoral() {
        return physicsoral;
    }

    public void setPhysicsoral(int physicsoral) {
        this.physicsoral = physicsoral;
    }

    public int getChemistryoral() {
        return chemistryoral;
    }

    public void setChemistryoral(int chemistryoral) {
        this.chemistryoral = chemistryoral;
    }

    public int getPhysicspractical() {
        return physicspractical;
    }

    public void setPhysicspractical(int physicspractical) {
        this.physicspractical = physicspractical;
    }

    public int getChemistrypractical() {
        return chemistrypractical;
    }

    public void setChemistrypractical(int chemistrypractical) {
        this.chemistrypractical = chemistrypractical;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getComputersc() {
        return computersc;
    }

    public void setComputersc(int computersc) {
        this.computersc = computersc;
    }
}
