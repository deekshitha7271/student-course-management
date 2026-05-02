<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course List</title>
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

        <h3>All Courses</h3>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Name</th>
                    <th>Duration (Months)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.courseName}</td>
                        <td>${course.duration}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
