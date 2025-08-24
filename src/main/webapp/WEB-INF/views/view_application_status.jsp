<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Application Status</title>
<link rel="stylesheet" type="text/css" href="./resources/css/view_application_status.css">
</head>
<body>

<div class="container">
    <h1>Application Status</h1>
    <table>
        <tr>
            <th>Request ID</th>
            <th>Request Date</th>
            <th>Capacity (KW)</th>
            <th>System Type</th>
            <th>Subsidy Requested</th>
            <th>Status</th>
        </tr>
        <% 
            List<InstallationRequest> requests = (List<InstallationRequest>)request.getAttribute("requests");
            for(InstallationRequest re : requests) {
                if(re.getResidentContactID() == Long.parseLong(request.getParameter("contactID"))) {
        %>
        <tr>
            <td><%=re.getReqid()%></td>
            <td><%=re.getReqDate()%></td>
            <td><%=re.getCapacityinKW()%></td>
            <td><%=re.getSystemType()%></td>
            <td><%=re.getSubsidyReq()%></td>
            <td><%=re.getReqstatus()%></td>
        </tr>
        <% 
                }
            } 
        %>
    </table>

    <div class="back-link">
        <a href="resident_dashboard?contactID=<%=request.getParameter("contactID") %>">Back to Dashboard</a>
    </div>
</div>

</body>
</html>
