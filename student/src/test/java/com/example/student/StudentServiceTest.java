package com.example.student;


import com.example.student.entities.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import com.example.student.serviceimpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {
    @TestConfiguration
    static class StudentServiceImplTestContextConfiguration {
        @Bean
        public StudentService studentService() {
            return new StudentServiceImpl();
        }
    }

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    private Student student1;
    private Student student2;

    private final List<Student> student = new ArrayList<>();
    private final int student1StudentNumber = 1057;
    private final int student2StudentNumber = 1056;
    private final int student1totalMarks = 398;
    private final int student2totalMarks = 399;

    @BeforeEach
    public void setup() {
        student1 = new Student();
        student1.setId("ABC123");
        student1.setStudentNumber(student1StudentNumber);
        student1.setName("Satyam");
        student1.setGender("M");
        student1.setPassStatus("PASS");
        student1.setTotalMarks(student1totalMarks);
        student1.setYearOfStudying(1);

        student2 = new Student();
        student1.setId("XYZ987");
        student2.setStudentNumber(student2StudentNumber);
        student2.setName("ayush");
        student2.setGender("F");
        student2.setPassStatus("FAIL");
        student2.setTotalMarks(student2totalMarks);
        student2.setYearOfStudying(2);

        student.add(student1);
        student.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(student);
        Mockito.when(studentRepository.findByStudentNumber(student1StudentNumber)).thenReturn(student1);
        Mockito.when(studentRepository.findTopBytotalMarks(student1totalMarks)).thenReturn(student1);
        Mockito.when(studentRepository.save(student1)).thenReturn(student1);
    }

    @Test
    public void TestFindByStudentNumber() {
        Student found = studentService.findByStudentNumber(student1StudentNumber);

        assertNotNull(found);
        assertEquals(student1.getStudentNumber(),found.getStudentNumber());
        assertEquals(student1.getGender(),found.getGender());
        assertEquals(student1.getId(),found.getId());
        assertEquals(student1.getName(),found.getName());
        assertEquals(student1.getPassStatus(),found.getPassStatus());
        assertEquals(student1.getTotalMarks(),found.getTotalMarks());
        assertEquals(student1.getYearOfStudying(),found.getYearOfStudying());
    }
}
