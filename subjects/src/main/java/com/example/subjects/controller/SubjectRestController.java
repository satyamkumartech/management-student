package com.example.subjects.controller;

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

import com.example.subjects.entities.Subjects;
import com.example.subjects.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectRestController {

    public final SubjectService subjectService;

    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/")
    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMINISTRATOR')")
    public List<Subjects> getAllSubjects() {
        return subjectService.findAllMarks();
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMINISTRATOR')")
    public Subjects getSubectsMarksByStudentNumber(@PathVariable("studentNumber")int studentNumber) {
        return subjectService.findByStudentNumber(studentNumber);
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<String> saveOrUpdateSubjects(@RequestBody Subjects subject) {
        subjectService.saveOrUpdateSubjects(subject);
        return ResponseEntity.ok("Subject Added to respective student no");
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<String> deleteSubjectByStudentNumber(@PathVariable int studentNumber) {
        subjectService.deleteSubjectById(subjectService.findByStudentNumber(studentNumber).getId());
        return ResponseEntity.ok("Subject Deleted corresponding to student");
    }
}
