package org.aman.hibernateDemo.service;

import jakarta.transaction.Transactional;
import org.aman.hibernateDemo.model.Student;
import org.aman.hibernateDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student student, Long id) {
        Student student1 = studentRepository.findById(id);

        if (student1 == null) {
            throw new RuntimeException("Student with id " + id + " not found");
        }

        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new RuntimeException("Student with id " + id + " not found");
        }

        studentRepository.remove(student);
    }
}
