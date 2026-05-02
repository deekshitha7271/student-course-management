<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Something Went Wrong</h2>
        
        <div class="error-box">
            <p>${errorMessage}</p>
        </div>

        <div class="nav">
            <a href="${pageContext.request.contextPath}/students" class="btn">Back to Students</a>
            <a href="${pageContext.request.contextPath}/addStudent" class="btn btn-secondary">Try Again</a>
        </div>
    </div>
</body>
</html>
