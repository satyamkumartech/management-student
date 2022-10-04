package com.example.student.serviceimpl;

import com.example.student.entities.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student findByMaximumMarks(int totalMarks) {
        return studentRepository.findHighestMarks(totalMarks);
    }

    @Override
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(String id) {

    }

    @Override
    public Student findByStudentNumber(int studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public List<Student> findByYear(int yearOfStudying) {
        return studentRepository.findByYear(yearOfStudying);
    }
}
