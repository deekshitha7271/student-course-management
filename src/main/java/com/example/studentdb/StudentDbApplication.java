package com.example.studentdb;

import com.example.studentdb.entity.Course;
import com.example.studentdb.entity.Student;
import com.example.studentdb.repository.CourseRepository;
import com.example.studentdb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDbApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(CourseRepository courseRepo, StudentRepository studentRepo) {
		return args -> {
			// Insert 10 Courses
			List<Course> courses = Arrays.asList(
					new Course("Java Full Stack", 6),
					new Course("Python for Data Science", 4),
					new Course("C++ Programming", 3),
					new Course("Web Development with React", 5),
					new Course("Cloud Computing (AWS)", 4),
					new Course("Mobile App Development (Flutter)", 6),
					new Course("Cyber Security Essentials", 4),
					new Course("Artificial Intelligence", 8),
					new Course("Database Management (MySQL)", 3),
					new Course("DevOps Engineering", 5)
			);
			courseRepo.saveAll(courses);

			// Insert 10 Students linked to courses
			List<Student> students = Arrays.asList(
					new Student("John Doe", "john@example.com", courses.get(0)),
					new Student("Jane Smith", "jane@example.com", courses.get(1)),
					new Student("Michael Brown", "michael@example.com", courses.get(2)),
					new Student("Emily Davis", "emily@example.com", courses.get(3)),
					new Student("William Wilson", "william@example.com", courses.get(4)),
					new Student("Olivia Taylor", "olivia@example.com", courses.get(5)),
					new Student("James Anderson", "james@example.com", courses.get(6)),
					new Student("Sophia Martinez", "sophia@example.com", courses.get(7)),
					new Student("Robert Thomas", "robert@example.com", courses.get(8)),
					new Student("Isabella Garcia", "isabella@example.com", courses.get(9))
			);
			studentRepo.saveAll(students);
			
			System.out.println("--- Database Seeded with 10 Courses and 10 Students ---");
		};
	}
}
