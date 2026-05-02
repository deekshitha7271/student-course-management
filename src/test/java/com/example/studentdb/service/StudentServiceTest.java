package com.example.studentdb.service;

import com.example.studentdb.entity.Course;
import com.example.studentdb.entity.Student;
import com.example.studentdb.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        Student s1 = new Student("Alice", "alice@example.com", new Course());
        Student s2 = new Student("Bob", "bob@example.com", new Course());
        when(studentRepository.findAll()).thenReturn(Arrays.asList(s1, s2));

        List<Student> result = studentService.getAllStudents();
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student("Charlie", "charlie@example.com", new Course());
        studentService.saveStudent(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student("David", "david@example.com", new Course());
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(1L);
        assertNotNull(result);
        assertEquals("David", result.getName());
    }
}
