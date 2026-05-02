# Academic Assignment Report: Student & Course Management System

**Project Title:** Student & Course Management System  
**Framework:** Spring Boot  
**Database:** MySQL  
**View Technology:** JSP & JSTL  

---

## 1. Introduction
The **Student & Course Management System** is a web-based application I developed to streamline the administration of academic records. Built using the Spring Boot framework, the application provides a robust platform for managing student enrollments and course offerings. My goal in building this project was to demonstrate the practical application of the Model-View-Controller (MVC) design pattern, relational database management using Spring Data JPA, and dynamic web content delivery through JavaServer Pages (JSP).

## 2. Objective
My primary objective was to implement a complete management system for two core entities: **Student** and **Course**. I aimed to facilitate fundamental CRUD (Create, Read, and Update) operations, ensuring that student data is accurately linked to specific courses. By managing these entities, I ensured data integrity and provided an intuitive interface for academic administrators.

## 3. Entity Relationship Design
I centered the system architecture around two primary entities:
-   **Course Entity**: Represents the academic programs. I included attributes such as `id` (Primary Key), `courseName`, and `duration`.
-   **Student Entity**: Represents individual students. I included attributes such as `id` (Primary Key), `name`, and `email`.

### Relationship Mapping
I established a **One-to-Many** relationship between Course and Student, where one course can contain multiple students. I also mapped a **Many-to-One** relationship from the Student to the Course.
-   **@Entity**: I used this to mark the classes as JPA entities.
-   **@Id & @GeneratedValue**: I defined the primary key with an auto-increment strategy.
-   **@OneToMany(mappedBy = "course")**: I added this in the Course entity to establish the bidirectional link.
-   **@ManyToOne & @JoinColumn**: I added these in the Student entity to create the foreign key relationship (`course_id`).

## 4. Implementation Details

### A. Populate Database
I configured Hibernate to automatically generate database tables using the `spring.jpa.hibernate.ddl-auto=update` property. To ensure the application was ready for testing immediately, I used the `CommandLineRunner` interface to seed the database with:
-   **10 Course Records**: Spanning various domains like Java, Python, and Cloud Computing.
-   **10 Student Records**: Each uniquely associated with a specific course to establish relationship integrity from the start.

### B. Create Operation
I developed the `add-student.jsp` form to handle new student entries.
-   **Process**: The user enters the name and email, and selects a course from a dynamic dropdown I populated from the database.
-   **Controller**: I implemented the `POST /saveStudent` method to bind the form data to a `Student` object.
-   **Service**: I used `studentService.saveStudent()` to persist the data via the repository.
-   **Exception Handling**: I employed `try-catch` blocks to handle `DataIntegrityViolationException`. If a duplicate email is entered, my system redirects the user to a custom `error.jsp` with a specific error message.

### C. Read Operation
I built the `students.jsp` page as the primary data display interface.
-   **Logic**: My `GET /students` endpoint retrieves all records using `studentService.getAllStudents()`.
-   **Binding**: I bound the data to the JSP model using JSTL `<c:forEach>` tags and accessed it via Expression Language (`${student.name}`). This allowed me to keep the logic and presentation layers clean and separated.

### D. INNER JOIN Implementation
To fulfill the requirement for complex data retrieval, I implemented a custom **INNER JOIN** query in the `StudentRepository` using JPQL:
```sql
SELECT s FROM Student s INNER JOIN s.course c WHERE c.courseName = :courseName
```
-   **Functionality**: This query fetches all students explicitly linked to a course matching the provided name.
-   **UI Integration**: I added a search filter on the Student List page so I could verify this join operation by filtering students based on their enrolled course.

### E. Update Operation
I created the `edit-student.jsp` interface to allow for student record modifications.
-   **Process**: When I click "Edit", the system loads the student’s current data into a pre-filled form.
-   **Execution**: My `POST /updateStudent` method handles the submission, updating the record in the database while maintaining the integrity of the existing primary key and relationship links.

## 5. Architecture
I followed a strict **Layered Architecture** to keep my code organized:
1.  **Entity Layer**: Data models I mapped to database tables.
2.  **Repository Layer**: Data access logic using Spring Data JPA.
3.  **Service Layer**: Business logic and transactional management.
4.  **Controller Layer**: Request mapping, model binding, and navigation logic.
5.  **View Layer (JSP)**: Front-end rendering using JSP and JSTL.

## 6. Repository Layer
I utilized `JpaRepository` for my repository layer, which provided all necessary CRUD functionality. I enhanced the `StudentRepository` with a custom `@Query` to perform the mandatory INNER JOIN operation.

## 7. Service Layer
I implemented the service layer as an intermediary to encapsulate my business logic. This ensured my controller did not interact directly with the repository, promoting better code structure.

## 8. Controller Layer
In the `StudentController`, I managed all incoming HTTP requests. I handled the data binding from forms to objects and directed the flow of the application by returning the appropriate JSP view names.

## 9. View Layer (JSP)
My presentation layer consists of several JSP pages I designed:
-   **add-student.jsp**: Form for data entry.
-   **students.jsp**: Tabular display of student records.
-   **edit-student.jsp**: Interface for record modification.
-   **courses.jsp**: List of all course entities.
-   **error.jsp**: Custom page for feedback on integrity violations.
-   **style.css**: I wrote this CSS to provide a clean and professional aesthetic for all my pages.

## 10. Technologies Used
-   **Java 17**
-   **Spring Boot 3.2.5**
-   **MySQL**
-   **Spring Data JPA / Hibernate**
-   **JSP & JSTL**

## 11. Challenges I Faced
-   **MySQL Connection**: I had to ensure the `studentdb` schema was created correctly and the JDBC credentials matched my local environment.
-   **JPA Relationships**: I carefully managed the bidirectional relationship between Student and Course to ensure data was saved correctly without errors.
-   **Data Binding**: I spent time ensuring that the nested course ID from the JSP form mapped correctly to my Java objects.

## 12. Output Screens

> **[Insert Screenshot: Student List Page]**  
> *Shows the list of students I seeded in the database.*

> **[Insert Screenshot: Add Student Form]**  
> *Shows the form I built for adding new students.*

> **[Insert Screenshot: Edit Student Page]**  
> *Shows the pre-filled form for updating records.*

> **[Insert Screenshot: Course List Page]**  
> *Shows all the course entities I created.*

> **[Insert Screenshot: INNER JOIN Filter Result]**  
> *Shows the result of my custom join query filter.*

> **[Insert Screenshot: MySQL Tables]**  
> *Shows my students and courses tables in MySQL.*

## 13. Conclusion
My **Student & Course Management System** successfully fulfills all project requirements. I have implemented a complete end-to-end Spring Boot application with MySQL persistence and JSP rendering. By including features like INNER JOIN queries and custom exception handling, I have created a functional and resilient application that meets professional standards.

## 14. GitHub Repository
**Project Link:** https://github.com/deekshitha7271/student-course-management

---
**Date:** May 3, 2026  
**Submitted By:** [Your Name/Student ID]
