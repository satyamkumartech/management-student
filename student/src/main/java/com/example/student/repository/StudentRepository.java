package com.example.student.repository;

import com.example.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    //List<Student> findAllByOrderMarks(int totalMarks);
    //Student findByPassFail(String passStatus);
    Student findFirstByTotalMarks(int totalMarks);
    Student findByStudentNumber(int studentNumber);
    //List<Student> findByYear(int yearOfStudying);
}
