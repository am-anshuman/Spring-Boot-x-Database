package org.aman.jpaRelationshipDemo.service;

import jakarta.transaction.Transactional;
import org.aman.jpaRelationshipDemo.model.Department;
import org.aman.jpaRelationshipDemo.model.Student;
import org.aman.jpaRelationshipDemo.repository.DepartmentRepository;
import org.aman.jpaRelationshipDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long deptId) {
        Department department = departmentRepository.getDepartmentById(deptId);

        student.setDepartment(department);
        department.getStudents().add(student);

        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName) {
        Department department = new Department();
        department.setName(deptName);

        student.setDepartment(department);

        department.getStudents().add(student);

        departmentRepository.save(department);

        studentRepository.save(student);
    }
}
