package org.aman.jpaRelationshipDemo.service;

import jakarta.transaction.Transactional;
import org.aman.jpaRelationshipDemo.model.Department;
import org.aman.jpaRelationshipDemo.model.Profile;
import org.aman.jpaRelationshipDemo.model.Student;
import org.aman.jpaRelationshipDemo.repository.DepartmentRepository;
import org.aman.jpaRelationshipDemo.repository.ProfileRepository;
import org.aman.jpaRelationshipDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository,
                          ProfileRepository profileRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student) {

        Department department = new Department();
        department.setName("CSE");

        Profile profile = new Profile();
        profile.setBio("Simple Bio");

        student.setDepartment(department);
        student.setProfile(profile);

        departmentRepository.save(department);
        profileRepository.save(profile);
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }
}
