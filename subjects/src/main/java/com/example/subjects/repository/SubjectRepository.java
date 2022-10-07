package com.example.subjects.repository;

import com.example.subjects.entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, String> {
    Subjects findByStudentNumber(int studentNumber);
}