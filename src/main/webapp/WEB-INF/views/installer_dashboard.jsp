<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.solar.model.*" %>
    <%@ page import="com.solar.dao.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Installer Dashboard</title>
    <link rel="stylesheet" type="text/css" href="./resources/css/installer_dashboard.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="sidebar glass">
            <h2><i class="fas fa-solar-panel"></i> Installer Panel</h2>
            <ul>
                <li><a href="view_approved_installation_request?contactID=<%=request.getAttribute("contactID") %>">
                    <i class="fas fa-check-circle"></i> Approved Requests</a></li>
                <li><a href="mark_installation_as_complete?contactID=<%=request.getAttribute("contactID") %>">
                    <i class="fas fa-tools"></i> Mark as Complete</a></li>
                <li><a href="change_passowrd?contactID=<%=request.getAttribute("contactID") %>">
                    <i class="fas fa-key"></i> Change Password</a></li>
                <li><a href="index">
                    <i class="fas fa-sign-out-alt"></i> Logout</a></li>
            </ul>
        </div>
        <% 
        Installer inst = (Installer)request.getAttribute("installer"); %>
        <div class="main-content fade-in">
            <h1>Welcome, Installer</h1>
            <p>Manage approved installations, mark completion, or change credentials.</p><br>
            <p>Advanced control for advanced energy.</p>
            
        </div>
    </div>
</body>
</html>
