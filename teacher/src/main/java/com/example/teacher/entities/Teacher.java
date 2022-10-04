package com.example.teacher.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @Column(name ="id")
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "tecaherId")
    private int tecaherId;

    public Teacher() {
    }

    public Teacher(String id, String username, String password, String name, int tecaherId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.tecaherId = tecaherId;
    }
}
