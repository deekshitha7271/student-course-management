<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Edit Student Details</h2>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/students" class="btn">View Students</a>
            <a href="${pageContext.request.contextPath}/courses" class="btn">View Courses</a>
        </div>

        <form action="${pageContext.request.contextPath}/updateStudent" method="post">
            <input type="hidden" name="id" value="${student.id}">
            
            <div>
                <label>Name:</label>
                <input type="text" name="name" value="${student.name}" required>
            </div>
            
            <div>
                <label>Email:</label>
                <input type="email" name="email" value="${student.email}" required>
            </div>
            
            <div>
                <label>Select Course:</label>
                <select name="course.id" required>
                    <c:forEach var="course" items="${courses}">
                        <option value="${course.id}" ${course.id == student.course.id ? 'selected' : ''}>
                            ${course.courseName} (${course.duration} Months)
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn">Update Student</button>
        </form>
    </div>
</body>
</html>
