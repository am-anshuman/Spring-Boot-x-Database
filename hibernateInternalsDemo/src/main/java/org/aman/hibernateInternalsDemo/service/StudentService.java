package org.aman.hibernateInternalsDemo.service;

import jakarta.transaction.Transactional;
import org.aman.hibernateInternalsDemo.model.Student;
import org.aman.hibernateInternalsDemo.repository.StudentRepository;
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
    public void updateStudent(Student studentReq, Long id) {
        Student student = studentRepository.findById(id);

        if (student == null) {
            throw new RuntimeException("Student with id " + id + " not found");
        }

        studentRepository.detach(student);

        student = studentRepository.attachAgain(student);

        student.setName(studentReq.getName());
        studentRepository.flush();

        student.setAge(studentReq.getAge());
        studentRepository.flush();

        student.setEmail(studentReq.getEmail());
        studentRepository.flush();
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
