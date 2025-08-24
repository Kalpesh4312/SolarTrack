<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Approve/Reject Installation Requests</title>
    <link rel="stylesheet" href="./resources/css/approve_reject_installation_request.css">
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
    <h1>Installation Requests</h1>

    <table>
        <thead>
            <tr>
                <th>Request ID</th>
                <th>System Type</th>
                <th>Capacity (KW)</th>
                <th>Subsidy Required</th>
                <th>Request Date</th>
                <th>Status</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<InstallationRequest> requests = (List<InstallationRequest>) request.getAttribute("requests");
                if (requests != null) {
                    for (InstallationRequest req : requests) {
            %>
            <tr>
                <td><%= req.getReqid() %></td>
                <td><%= req.getSystemType() %></td>
                <td><%= req.getCapacityinKW() %></td>
                <td><%= req.getSubsidyReq() %></td>
                <td><%= req.getReqDate() %></td>
                <td><%= req.getReqstatus() %></td>
                <td>
				    <button class="approve"><a href="approve?reqid=<%=req.getReqid()%>">Approve</a></button>
				    <button class="reject"><a href="reject?reqid=<%=req.getReqid()%>">Reject</a></button>
				</td>
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
