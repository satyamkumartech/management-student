package com.example.student.serviceimpl;

import com.example.student.entities.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    @Override
    public Student findTopBytotalMarks(int totalMarks) {
        return studentRepository.findTopBytotalMarks(totalMarks);
    }
    @Override
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
    @Override
    public Student findByStudentNumber(int studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }
}
