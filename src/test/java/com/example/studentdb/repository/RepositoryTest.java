package com.example.studentdb.repository;

import com.example.studentdb.entity.Course;
import com.example.studentdb.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testSaveAndFetchStudent() {
        Course course = new Course("Test Course", 1);
        courseRepository.save(course);

        Student student = new Student("Test Student", "test@test.com", course);
        studentRepository.save(student);

        Student fetched = studentRepository.findById(student.getId()).orElse(null);
        assertNotNull(fetched);
        assertEquals("Test Student", fetched.getName());
    }

    @Test
    public void testFindStudentsByCourseName() {
        Course c1 = new Course("Java", 6);
        Course c2 = new Course("Python", 4);
        courseRepository.saveAll(List.of(c1, c2));

        studentRepository.save(new Student("Alice", "alice@java.com", c1));
        studentRepository.save(new Student("Bob", "bob@python.com", c2));

        List<Student> javaStudents = studentRepository.findStudentsByCourseName("Java");
        assertEquals(1, javaStudents.size());
        assertEquals("Alice", javaStudents.get(0).getName());
    }
}
