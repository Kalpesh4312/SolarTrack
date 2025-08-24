<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resident Dashboard</title>
<link rel="stylesheet" type="text/css" href="./resources/css/resident_dashboard.css">
</head>
<body>

<div class="dashboard-container">
    <div class="sidebar">
        <h2>Resident Panel</h2>
        <ul>
            <li><a href="apply_installations?contactID=<%=request.getParameter("contactID")%>">Apply for Installation</a></li>
            <li><a href="view_application_status?contactID=<%=request.getParameter("contactID")%>">View Application Status</a></li>
            <li><a href="view_installations_subsidy_reports?contactID=<%=request.getParameter("contactID")%>">View Reports</a></li>
            <li><a href="index">Logout</a></li>
        </ul>
    </div>

    <div class="main-content">
        <h1>Welcome, Resident</h1>
        <p>Choose an option from the sidebar to continue.</p>
        <p>Efficiency in action. Sustainability in progress.</p>
    </div>
</div>

</body>
</html>
