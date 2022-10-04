package com.example.subjects.entities;

import javax.persistence.*;

@Entity
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
}
