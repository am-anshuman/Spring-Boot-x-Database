package org.aman.jpaRelationshipDemo.service;

import jakarta.transaction.Transactional;
import org.aman.jpaRelationshipDemo.model.Department;
import org.aman.jpaRelationshipDemo.model.Student;
import org.aman.jpaRelationshipDemo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        Student s1 = new Student();
        s1.setName("Aman");
        s1.setDepartment(department);

        Student s2 = new Student();
        s2.setName("Anshu");
        s2.setDepartment(department);

        Student s3 = new Student();
        s3.setName("Rohit");
        s3.setDepartment(department);

        Student s4 = new Student();
        s4.setName("Rohan");
        s4.setDepartment(department);

        // department.getStudents().addAll(List.of(s1, s2, s3, s4));

        departmentRepository.save(department);
    }

    @Transactional
    public void removeDepartment(Long id) {

        Department department = departmentRepository.findById(id);

        departmentRepository.remove(department);
    }
}
