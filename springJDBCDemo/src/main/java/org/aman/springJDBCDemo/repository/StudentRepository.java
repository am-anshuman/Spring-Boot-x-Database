package org.aman.springJDBCDemo.repository;

import org.aman.springJDBCDemo.mapper.StudentRowMapper;
import org.aman.springJDBCDemo.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    private final StudentRowMapper studentRowMapper = new StudentRowMapper();

    // private final RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

    private static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createStudent(Student student) {
        String sql =
                """
                INSERT INTO students(name, email, age) VALUES (?, ?, ?)
                """;

        int rowAffected = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getAge());

        if(rowAffected == 1) {
            logger.info("Create operation successful");
        } else {
            logger.info("Create operation failed");
        }
    }

    public void updateStudent(Student student, Long id) {
        String sql =
                """
                UPDATE students 
                SET name = ?, 
                    email = ?, 
                    age = ? 
                WHERE id = ?
                """;

        int rowAffected = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getAge(), id);

        if(rowAffected == 1) {
            logger.info("Update operation successful");
        } else {
            logger.info("Update operation failed");
        }
    }

    public void deleteStudent(Long id) {
        String sql =
                """
                DELETE FROM students WHERE id = ?
                """;

        int rowAffected = jdbcTemplate.update(sql, id);

        if(rowAffected == 1) {
            logger.info("Delete operation successful");
        } else {
            logger.info("Delete operation failed");
        }
    }

    public Student getStudentById(Long id) {
        String sql =
                """
                SELECT id, name, email, age FROM students WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(sql, studentRowMapper, id);
    }

    public List<Student> getAllStudents() {
        String sql =
                """
                SELECT id, name, email, age FROM students
                """;

        List<Student> students = jdbcTemplate.query(sql, studentRowMapper);

        return students;
    }
}
