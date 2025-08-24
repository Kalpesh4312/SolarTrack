<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.solar.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mark Installations As Complete</title>
<link rel="stylesheet" type="text/css" href="./resources/css/mark_installation_as_complete.css">
</head>
<body>
<form action="installationmarkcomplete" method="post">
<input type="hidden" name="contactID" value="<%=request.getParameter("contactID") %>">
<label>RequestID : </label>
<input type="text" name="reqID" required> 
<label>SystemCost : </label>
<input type="text" name="scost" required> 
<label>SubsidyAproved : </label>
<input type="radio" name="subsidyAproved" value="yes" required> Yes
<input type="radio" name="subsidyAproved" value="no"  required> No
<label>Remark : </label>
<input type="text" name="remark" required> 
<button type="submit">Mark as Install</button>
</form>

<table>
<tr>
<th>InstalationID</th>
<th>ReqID</th>
<th>InstallDate</th>
<th>SystemCost</th>
<th>SubsidyApproved</th>
<th>Remarks</th>
<th>CreateReport</th>
</tr>

<% List<Installation> list = (List<Installation>) request.getAttribute("installations");  
for(Installation li : list){
	if(li.getIcontactID() == Long.parseLong(request.getParameter("contactID"))){

%>
<tr>
<td><%=li.getIid() %></td>
<td><%=li.getReqID() %></td>
<td><%=li.getInstallDate() %></td>
<td><%=li.getSystemCostt() %></td>
<td><%=li.getSubsidyApproved() %></td>
<td><%=li.getRemarks() %></td>
<td><button type="submit"><a href="create_report?installationID=<%=li.getIid() %>&contactID=<%=request.getParameter("contactID") %>">Create Report</a></button></td>
</tr>
<%
	}
}
%>
</table>
<h3><a href="installer_dashboard?contactID=<%=request.getParameter("contactID")%>">Return To DashBOard</a></h3>
</body>
</html>