<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Add New Student</h2>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/students" class="btn">View Students</a>
            <a href="${pageContext.request.contextPath}/courses" class="btn">View Courses</a>
        </div>

        <form action="${pageContext.request.contextPath}/saveStudent" method="post">
            <div>
                <label>Name:</label>
                <input type="text" name="name" required placeholder="Enter student name">
            </div>
            
            <div>
                <label>Email:</label>
                <input type="email" name="email" required placeholder="Enter student email">
            </div>
            
            <div>
                <label>Select Course:</label>
                <select name="course.id" required>
                    <option value="">-- Choose a Course --</option>
                    <c:forEach var="course" items="${courses}">
                        <option value="${course.id}">${course.courseName} (${course.duration} Months)</option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn">Save Student</button>
        </form>
    </div>
</body>
</html>
