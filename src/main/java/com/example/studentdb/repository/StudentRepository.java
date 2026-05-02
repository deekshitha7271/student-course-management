package com.example.studentdb.repository;

import com.example.studentdb.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s INNER JOIN s.course c WHERE c.courseName = :courseName")
    List<Student> findStudentsByCourseName(@Param("courseName") String courseName);
}
