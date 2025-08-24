<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Installer - Admin Panel</title>
    <link rel="stylesheet" href="./resources/css/installer_add.css">
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>Admin</h2>
    <a href="add_view_delete_installers">Add/View/Delete Installers</a>
    <a href="view_residents">View Residents</a>
    <a href="approve_reject_installation_request">Approve/Reject Installation</a>
    <a href="view_subsidy_reports">View Subsidy Reports</a>
    <a href="index">Log Out</a>
</div>

<!-- Main Content -->
<div class="dashboard-content">
    <h1>Enter Installer Details</h1>

    <form class="installer-form" action="add_installer" method="post">
        <label>Name:</label>
        <input type="text" name="iname" required>

        <label>License No:</label>
        <input type="text" name="ilicense" required>

        <label>Email:</label>
        <input type="email" name="iemail" required>

        <label>Contact:</label>
        <input type="text" name="icontact" minlength="10" maxlength="10" required>

        <label>Password:</label>
        <input type="password" name="ipassword" required>

        <button type="submit">Register</button>
    </form>

    <p><a href="add_view_delete_installers">Back to Dashboard</a></p>
</div>

</body>
</html>
