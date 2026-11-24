package org.aman.jpaRelationshipDemo.service;

import jakarta.transaction.Transactional;
import org.aman.jpaRelationshipDemo.model.Student;
import org.aman.jpaRelationshipDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId) {

    }
}
