package com.example.studentdb.service;

import com.example.studentdb.entity.Student;
import com.example.studentdb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudentsByCourseName(String courseName) {
        return studentRepository.findStudentsByCourseName(courseName);
    }
}
