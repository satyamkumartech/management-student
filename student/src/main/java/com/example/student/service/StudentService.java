package com.example.student.service;

import com.example.student.entities.Student;

import java.util.List;

public interface StudentService {
    List<Objec> findSubject();
    List<Student> findAll();
    Student findFirstByTotalMarks(int totalMarks);
    Student saveOrUpdateStudent(Student student);
    void deleteStudentById(String id);
    Student findByStudentNumber(int studentNumber);
    //List<Student> findByYear(int yearOfStudying);
}
