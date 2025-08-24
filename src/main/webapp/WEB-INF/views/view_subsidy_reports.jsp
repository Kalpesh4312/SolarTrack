<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Subsidy Reports</title>
    <link rel="stylesheet" type="text/css" href="./resources/css/view_subsidy_reports.css">
</head>
<body>

<div class="sidebar">
    <h2>Admin</h2>
    <a href="add_view_delete_installers">Add/View/Delete Installers</a>
    <a href="view_residents">View Residents</a>
    <a href="approve_reject_installation_request">Approve/Reject Installation</a>
    <a href="view_subsidy_reports">View Subsidy Reports</a>
    <a href="index">Log Out</a>
</div>

<div class="dashboard-content">
    <h1>Subsidy Reports</h1>
    <table>
        <thead>
            <tr>
                <th>Report ID</th>
                <th>Installation ID</th>
                <th>Maintenance Note</th>
                <th>Power Generated</th>
                <th>Report Date</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Report> reports = (List<Report>) request.getAttribute("reports");
                if (reports != null) {
                    for (Report repo : reports) {
            %>
            <tr>
                <td><%= repo.getReportID() %></td>
                <td><%= repo.getInstallationID() %></td>
                <td><%= repo.getMaintananceNote() %></td>
                <td><%= repo.getPowerGenerated() %></td>
                <td><%= repo.getReportDate() %></td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</div>

</body>
</html>
