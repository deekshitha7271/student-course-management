# Student & Course Management System

A complete Spring Boot web application using Maven to manage Students and Courses. This project implements full CRUD operations, complex JPA relationships, and custom INNER JOIN queries.

##  Features
- **Student Management**: Create, Read, and Update students.
- **Course Management**: List all available courses.
- **Inner Join Search**: Custom JPQL query to filter students by course name.
- **Data Integrity**: Exception handling for database constraints (e.g., unique email).
- **Automated Seeding**: Populates 10 courses and 10 students on startup via `CommandLineRunner`.

##  Tech Stack
- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **MySQL**
- **JSP & JSTL** (Tomcat Jasper)
- **Maven**

##  Prerequisites
- JDK 17 or higher
- MySQL Server
- Maven

##  Configuration
1. Create a MySQL database named `studentdb`.
2. Update `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

##  How to Run
```bash
mvn spring-boot:run
```
Once started, access the application at:
`http://localhost:8080/students`

##  Project Structure
- `com.example.studentdb.entity`: JPA Entities (`Student`, `Course`).
- `com.example.studentdb.repository`: Data access interfaces.
- `com.example.studentdb.service`: Business logic layer.
- `com.example.studentdb.controller`: MVC Controllers.
- `src/main/webapp/WEB-INF/jsp`: View templates.
