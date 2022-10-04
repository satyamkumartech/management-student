package com.example.subjects.serviceimpl;

import com.example.subjects.entities.Subjects;
import com.example.subjects.repository.SubjectRepository;
import com.example.subjects.service.SubjectService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public List<Subjects> findAllMarks() {
        return subjectRepository.findAll();
    }

    @Override
    public Subjects findByStudentNumber(int studentNumber) {
        return subjectRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public Subjects saveOrUpdateSubjects(Subjects subject) {
        return subjectRepository.save(subject);
    }
}
