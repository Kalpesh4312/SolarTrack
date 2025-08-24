<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Report</title>
<link rel="stylesheet" type="text/css" href="./resources/css/create_report.css">
</head>
<body>
<h3>Crete report</h3>
<form action="reportcreateform" method="post">
<input type="hidden" name="contactID" value=<%=request.getParameter("contactID") %>>
<input type="hidden" name="installationID" value="<%=request.getParameter("installationID") %>">
<label>PowerGenerated : </label>
<input type="text" name="powerGenerated" required>
<label>MAintainence Notes : </label>
<input type="text" name="maintainanceNote" required>
<button type="submit">Create Report</button>
</form>
</body>
</html>