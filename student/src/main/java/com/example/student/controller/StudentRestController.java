package com.example.student.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entities.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMINISTRATOR')")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(value = "/highestMarks")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMINISTRATOR')")
    public Student getStudentByMarks(int totalMarks) {
        return studentService.findFirstByTotalMarks(totalMarks);
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMINISTRATOR')")
    public Student getStudentByStudentNumber(@PathVariable("studentNumber")int studentNumber){
        return studentService.findByStudentNumber(studentNumber);
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<String> saveOrUpdateStudent(@RequestBody Student student) {
        studentService.saveOrUpdateStudent(student);
        return ResponseEntity.ok("Student Added");
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<String> deleteStudentByStudentNumber(@PathVariable int studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        return ResponseEntity.ok("Student deleted");
    }

    @GetMapping(value = "/findsubject")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_ADMINISTRATOR')")
    public List fetchAllSubject() {
        return studentService.findSubject();
    }
}
