package com.example.subjects.controller;

import com.example.subjects.entities.Subjects;
import com.example.subjects.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectRestController {

    public final SubjectService subjectService;

    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/")
    public List<Subjects> getAllSubjects() {
        return subjectService.findAllMarks();
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    public Subjects getSubectsMarksByStudentNumber(@PathVariable("studentNumber")int studentNumber) {
        return subjectService.findByStudentNumber(studentNumber);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateSubjects(@RequestBody Subjects subject) {
        subjectService.saveOrUpdateSubjects(subject);
        return new ResponseEntity("Subject Added to respective student no", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteSubjectByStudentNumber(@PathVariable int studentNumber) {
        subjectService.deleteSubjectById(subjectService.findByStudentNumber(studentNumber).getId());
        return new ResponseEntity("Subject Deleted corresponding to student",HttpStatus.OK);
    }
}
