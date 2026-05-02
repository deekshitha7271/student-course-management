# Project Documentation: Student & Course Management System

## Project Overview
This application is a Spring Boot web-based management system for tracking students and their enrolled courses. It demonstrates the use of a layered architecture (MVC), Spring Data JPA with MySQL, and JSP for the view layer.

## Architecture
The project follows a standard 4-layer architecture:
1.  **Entity Layer**: JPA entities (`Student`, `Course`) representing database tables with relationships.
2.  **Repository Layer**: Interfaces extending `JpaRepository` for data access. Includes a custom INNER JOIN query.
3.  **Service Layer**: Business logic encapsulating repository calls.
4.  **Controller Layer**: Spring MVC controllers handling HTTP requests and model binding.

## Key Features
-   **CRUD Operations**: Create, Read, and Update students.
-   **Course Listing**: View all available courses.
-   **Inner Join Integration**: A search feature that uses a custom JPQL query to perform an `INNER JOIN` between students and courses, filtering by course name.
-   **Exception Handling**: Global and local exception handling for data integrity violations (e.g., duplicate email) using a dedicated error page.
-   **Data Seeding**: Automatically populates the database with 10 courses and 10 students on startup.
-   **JSP & JSTL**: Modern data binding using Expression Language (EL) and JSTL tags for clean view logic.

## Technical Stack
-   **Java 17**
-   **Spring Boot 3.2.5**
-   **Spring Data JPA**
-   **MySQL Database**
-   **JSP & JSTL** (Tomcat Jasper)
-   **JUnit & Mockito** for Testing

## Database Schema
### Courses Table
-   `id` (BIGINT, PK)
-   `course_name` (VARCHAR)
-   `duration` (INT)

### Students Table
-   `id` (BIGINT, PK)
-   `name` (VARCHAR)
-   `email` (VARCHAR, UNIQUE)
-   `course_id` (BIGINT, FK)

## Implementation Highlights
### Custom INNER JOIN Query
```java
@Query("SELECT s FROM Student s INNER JOIN s.course c WHERE c.courseName = :courseName")
List<Student> findStudentsByCourseName(@Param("courseName") String courseName);
```

### Exception Handling
```java
@PostMapping("/saveStudent")
public String saveStudent(@ModelAttribute("student") Student student, Model model) {
    try {
        studentService.saveStudent(student);
        return "redirect:/students";
    } catch (DataIntegrityViolationException e) {
        model.addAttribute("errorMessage", "Error: Email already exists.");
        return "error";
    }
}
```

## How to Run
1.  Ensure MySQL is running and a database named `studentdb` exists.
2.  Update `application.properties` with your MySQL credentials.
3.  Run the application using: `mvn spring-boot:run`.
4.  Access the application at `http://localhost:8080/students`.
