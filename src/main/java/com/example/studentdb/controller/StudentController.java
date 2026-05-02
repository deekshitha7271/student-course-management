package com.example.studentdb.controller;

import com.example.studentdb.entity.Course;
import com.example.studentdb.entity.Student;
import com.example.studentdb.service.CourseService;
import com.example.studentdb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/addStudent")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        return "add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
        try {
            studentService.saveStudent(student);
            return "redirect:/students";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Error: A student with this email already exists or there is a database integrity violation.");
            return "error";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/editStudent/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            model.addAttribute("errorMessage", "Student not found with ID: " + id);
            return "error";
        }
        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAllCourses());
        return "edit-student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student student, Model model) {
        try {
            studentService.updateStudent(student);
            return "redirect:/students";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error updating student: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("courseName") String courseName, Model model) {
        List<Student> students = studentService.getStudentsByCourseName(courseName);
        model.addAttribute("students", students);
        model.addAttribute("searchQuery", courseName);
        return "students";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", "Global Error: " + e.getMessage());
        return "error";
    }
}
