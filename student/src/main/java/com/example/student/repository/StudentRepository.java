package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    //List<Student> findAllByOrderMarks(int totalMarks);
    //Student findByPassFail(String passStatus);
    Student findFirstByTotalMarks(int totalMarks);
    Student findByStudentNumber(int studentNumber);
    //List<Student> findByYear(int yearOfStudying);
}
