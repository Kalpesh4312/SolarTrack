<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Installations and Subsidy Reports</title>
<link rel="stylesheet" type="text/css" href="./resources/css/view_installations_subsidy_reports.css">
<script>
    function showSection(sectionId) {
        document.getElementById("installationsTable").style.display = "none";
        document.getElementById("subsidyTable").style.display = "none";

        document.getElementById(sectionId).style.display = "block";

        document.getElementById("btnInstall").classList.remove("active");
        document.getElementById("btnSubsidy").classList.remove("active");
        document.getElementById("btn" + sectionId.charAt(0).toUpperCase() + sectionId.slice(1)).classList.add("active");
    }

    window.onload = function() {
        showSection("installationsTable");
    };
</script>
</head>
<body>

<div class="container">
    <div class="toggle-buttons">
        <button id="btnInstall" onclick="showSection('installationsTable')">Installation Details</button>
        <button id="btnSubsidy" onclick="showSection('subsidyTable')">Subsidy Reports</button>
    </div>

    <div id="installationsTable" class="toggle-section">
        <h1>Installation Details</h1>
        <table>
            <tr>
                <th>Installation ID</th>
                <th>System Cost</th>
                <th>Installer Contact</th>
                <th>Install Date</th>
                <th>Remark</th>
                <th>Request ID</th>
                <th>Subsidy Approved</th>
            </tr>
            <%
                List<Installation> installations = (List<Installation>)request.getAttribute("installations");
                for (Installation insta : installations) {
            %>
            <tr>
                <td><%=insta.getIid() %></td>
                <td><%=insta.getSystemCostt() %></td>
                <td><%=insta.getIcontactID() %></td>
                <td><%=insta.getInstallDate() %></td>
                <td><%=insta.getRemarks() %></td>
                <td><%=insta.getReqID() %></td>
                <td><%=insta.getSubsidyApproved() %></td>
            </tr>
            <% } %>
        </table>
    </div>

    <div id="subsidyTable" class="toggle-section" style="display: none;">
        <h1>Subsidy Reports</h1>
        <table>
            <tr>
                <th>Report ID</th>
                <th>Installation ID</th>
                <th>Maintenance Note</th>
                <th>Power Generated</th>
                <th>Report Date</th>
            </tr>
            <%
                List<Report> reports = (List<Report>)request.getAttribute("reports");
                for (Report repo : reports) {
            %>
            <tr>
                <td><%=repo.getReportID() %></td>
                <td><%=repo.getInstallationID() %></td>
                <td><%=repo.getMaintananceNote() %></td>
                <td><%=repo.getPowerGenerated() %></td>
                <td><%=repo.getReportDate() %></td>
            </tr>
            <% } %>
        </table>
    </div>

    <div class="back-link">
        <a href="resident_dashboard?contactID=<%=request.getParameter("contactID") %>">Back to Dashboard</a>
    </div>
</div>

</body>
</html>
