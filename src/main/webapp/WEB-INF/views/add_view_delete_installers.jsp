<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Installers Management - Admin Panel</title>
    <link rel="stylesheet" href="./resources/css/add_view_delete_installer.css">
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
    <h1>Installers List</h1>
    <h3><a href="installer_add" class="add-btn">Add Installer</a></h3>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>License</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% List<Installer> li = (List<Installer>)request.getAttribute("installers");
           for (Installer i : li) { %>
        <tr>
            <td><%=i.getIname() %></td>
            <td><%=i.getIlicense() %></td>
            <td><%=i.getIemail() %></td>
            <td><%=i.getIcontact() %></td>
            <td><%=i.getIpassword() %></td>
            <td><a href="delete?icontact=<%=i.getIcontact() %>" class="delete-btn">Delete</a></td>
        </tr>
        <% } %>
        </tbody>
    </table>

</div>

</body>
</html>
