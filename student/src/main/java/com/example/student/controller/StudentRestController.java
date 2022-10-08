package com.example.student.controller;

import com.example.student.entities.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(value = "/highestMarks")
    public Student getStudentByMarks(int totalMarks) {
        return studentService.findFirstByTotalMarks(totalMarks);
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    public Student getStudentByStudentNumber(@PathVariable("studentNumber")int studentNumber){
        return studentService.findByStudentNumber(studentNumber);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student student) {
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Student Added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable int studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        return new ResponseEntity("Student deleted",HttpStatus.OK);
    }

    @GetMapping(value = "/findsubject")
    public List fetchAllSubject() {
        return studentService.findSubject();
    }
}
