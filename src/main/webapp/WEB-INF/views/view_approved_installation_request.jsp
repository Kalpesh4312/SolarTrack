<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.solar.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Approved Installation Requests</title>
    <link rel="stylesheet" type="text/css" href="./resources/css/view_approved_installation_request.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="glass-table-wrapper">
        <h1>Approved Installation Requests</h1>
        <table>
            <thead>
                <tr>
                    <th>ReqID</th>
                    <th>ReqDate</th>
                    <th>SystemType</th>
                    <th>SubsidyReq</th>
                    <th>CapacityKW</th>
                    <th>ResidentContact</th>
                    <th>ReqStatus</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<InstallationRequest> ir = (List<InstallationRequest>)request.getAttribute("requests"); 
                    for(InstallationRequest irr : ir){
                        if("Approved".equals(irr.getReqstatus())){
                %>
                <tr>
                    <td><%=irr.getReqid() %></td>
                    <td><%=irr.getReqDate() %></td>
                    <td><%=irr.getSystemType() %></td>
                    <td><%=irr.getSubsidyReq() %></td>
                    <td><%=irr.getCapacityinKW() %></td>
                    <td><%=irr.getResidentContactID() %></td>
                    <td><%=irr.getReqstatus() %></td>
                </tr>
                <% }} %>
            </tbody>
        </table>
        <a class="btn" href="installer_dashboard?contactID=<%=request.getParameter("contactID")%>">Return to Dashboard</a>
    </div>
</body>
</html>
