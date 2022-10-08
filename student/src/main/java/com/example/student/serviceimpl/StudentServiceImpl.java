package com.example.student.serviceimpl;

import com.example.student.entities.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.Objec;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    static final String SECOND_SERVICE_URL ="http://localhost:8082/";

    @Override
    public List<Objec> findSubject() {
        return restTemplate.exchange(SECOND_SERVICE_URL, HttpMethod.GET,null,List.class).getBody();
    }
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    @Override
    public Student findFirstByTotalMarks(int totalMarks) {
        return studentRepository.findFirstByTotalMarks(totalMarks);
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
