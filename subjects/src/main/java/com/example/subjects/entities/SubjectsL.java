package com.example.subjects.entities;

import javax.persistence.*;

@Entity
public class SubjectsL {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "physics")
    private int physics;
    @Column(name = "chemistry")
    private int chemistry;
    @Column(name = "language")
    private int language;
    @Column(name = "maths")
    private int maths;
    @Column(name = "computersc")
    private int computersc;
}
