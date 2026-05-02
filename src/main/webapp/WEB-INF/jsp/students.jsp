<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Student Management System</h2>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/students" class="btn">View Students</a>
            <a href="${pageContext.request.contextPath}/courses" class="btn">View Courses</a>
            <a href="${pageContext.request.contextPath}/addStudent" class="btn btn-secondary">Add New Student</a>
        </div>

        <h3>All Students</h3>
        
        <!-- INNER JOIN Search Verification -->
        <div class="search-box">
            <form action="${pageContext.request.contextPath}/students/search" method="get" style="display: flex; gap: 10px; max-width: none;">
                <input type="text" name="courseName" placeholder="Search by Course Name (e.g. Java Full Stack)" value="${searchQuery}">
                <button type="submit" class="btn">Filter by Course (INNER JOIN)</button>
            </form>
            <c:if test="${not empty searchQuery}">
                <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">Clear Filter</a>
            </c:if>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Course Name</th>
                    <th>Duration (Months)</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.course.courseName}</td>
                        <td>${student.course.duration}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/editStudent/${student.id}" class="btn">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty students}">
                    <tr>
                        <td colspan="6" style="text-align: center;">No students found.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</body>
</html>
