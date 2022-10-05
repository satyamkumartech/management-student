package com.example.subjects.service;

import com.example.subjects.entities.Subjects;

import java.util.List;

public interface SubjectService {
    List<Subjects> findAllMarks();

    Subjects findByStudentNumber(int studentNumber);

    Subjects saveOrUpdateSubjects(Subjects subjects);
    void deleteSubjectById(String id);
}
