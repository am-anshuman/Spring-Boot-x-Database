package org.aman;

import org.aman.model.Student;
import org.aman.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();

        // studentRepository.createStudent(new Student("Aman", "aman@mail.com", 24));

        // studentRepository.updateStudent(new Student("Anshuman Sahu", "anshu@mail.com", 25), 3L);

        // studentRepository.deleteStudent(2L);

        // studentRepository.getStudentById(3L);

        studentRepository.getAllStudents();
    }
}