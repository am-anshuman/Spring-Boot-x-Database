package org.aman.jpaRelationshipDemo.service;

import jakarta.transaction.Transactional;
import org.aman.jpaRelationshipDemo.model.Department;
import org.aman.jpaRelationshipDemo.model.Student;
import org.aman.jpaRelationshipDemo.repository.DepartmentRepository;
import org.aman.jpaRelationshipDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName) {
        departmentRepository.save(department);

        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        department.getStudents().add(student);

        studentRepository.save(student);
    }
}
