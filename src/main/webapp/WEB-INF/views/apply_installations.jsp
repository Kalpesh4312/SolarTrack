<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.ui.Model" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply for Solar Installation</title>
<link rel="stylesheet" type="text/css" href="./resources/css/apply_installations.css">
</head>
<body>

<div class="form-container">
    <h1>Apply for Solar Installation</h1>
    <form action="applyforINstallationrequest" method="post">

        <input type="hidden" name="contactID" value="<%=request.getParameter("contactID") %>"/>

        <div class="form-section">
            <label>Select Solar Type:</label><br>
            <label><input type="radio" name="solarType" value="Grid-Tie" required> Grid-Tie</label>
            <label><input type="radio" name="solarType" value="Off-Grid" required> Off-Grid</label>
            <label><input type="radio" name="solarType" value="BackUP" required> BackUP</label>
        </div>

        <div class="form-section">
            <label>Select Capacity (per hour):</label><br>
            <label><input type="radio" name="capacityKW" value="0.5kw" required> 0.5kw</label>
            <label><input type="radio" name="capacityKW" value="1.5kw" required> 1.5kw</label>
            <label><input type="radio" name="capacityKW" value="2.5kw" required> 2.5kw</label>
        </div>

        <div class="form-section">
            <label>Subsidy Request:</label><br>
            <label><input type="radio" name="subsidyreq" value="10%" required> 10%</label>
            <label><input type="radio" name="subsidyreq" value="25%" required> 25%</label>
            <label><input type="radio" name="subsidyreq" value="50%" required> 50%</label>
        </div>

        <div class="form-section">
            <button type="submit">Submit Application</button>
        </div>
    </form>

    <div class="back-link">
        <a href="resident_dashboard?contactID=<%=request.getParameter("contactID") %>">Back to Dashboard</a>
    </div>
</div>

</body>
</html>
