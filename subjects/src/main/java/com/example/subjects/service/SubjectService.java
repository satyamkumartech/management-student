package com.example.subjects.service;

import com.example.subjects.entities.Subjects;

import java.util.List;

public interface SubjectService {
    List<Subjects> findAllMarks();
    Subjects findByStudentNumber(int studentNumber);
    Subjects saveOrUpdateSubjects(Subjects subject);
    void deleteSubjectById(String id);
}
