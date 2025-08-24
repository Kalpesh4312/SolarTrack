<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="./resources/css/change_passowrd.css">

</head>
<body>
<h3>Change Your Password</h3>
<form action="changePAsswordofinstaller" method="post">
<input type="hidden" name="contactID" value="<%=request.getParameter("contactID") %>">
<label>Enter old Password :</label>
<input type="password" name="oldpass" required>
<label>Enter New Password : </label>
<input type="password" name="newpass" required>
<button type="submit">Change Password</button>

</form>
<h3><a href="installer_dashboard?contactID=<%=request.getParameter("contactID")%>">Return To DashBOard</a></h3>
</body>
</html>