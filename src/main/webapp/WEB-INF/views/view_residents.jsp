<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Residents - Admin Panel</title>
    <link rel="stylesheet" href="./resources/css/view_residents.css">
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
    <h1>Registered Residents</h1>

    <input type="text" id="searchInput" onkeyup="filterTable()" placeholder="Search by Name or Contact">

    <table id="residentsTable">
        <thead>
        <tr>
            <th>Name</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Aadhar</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Resident> resi = (List<Resident>) request.getAttribute("residents");
            for (Resident rs : resi) {
        %>
        <tr>
            <td><%= rs.getRname() %></td>
            <td><%= rs.getRcontact() %></td>
            <td><%= rs.getRemail() %></td>
            <td><%= rs.getRadhar() %></td>
            <td><%= rs.getrAddress() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

</div>

<script>
    function filterTable() {
        let input = document.getElementById("searchInput").value.toLowerCase();
        let rows = document.querySelectorAll("#residentsTable tbody tr");
        rows.forEach(row => {
            let name = row.cells[0].innerText.toLowerCase();
            let contact = row.cells[1].innerText.toLowerCase();
            row.style.display = name.includes(input) || contact.includes(input) ? "" : "none";
        });
    }
</script>

</body>
</html>
