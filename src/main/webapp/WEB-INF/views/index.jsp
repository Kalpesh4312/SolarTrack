<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SolarTrack - Login</title>
<link rel="stylesheet" href="./resources/css/style.css">
</head>
<body>
<div class="container">
    <h1>Welcome to SolarTrack Login</h1>

    <!-- Form Switch Toggle -->
    <div class="form-toggle">
        <button onclick="switchForm('adminForm')" id="adminBtn" class="active">Admin</button>
        <button onclick="switchForm('residentForm')" id="residentBtn">Resident</button>
        <button onclick="switchForm('installerForm')" id="installerBtn">Installer</button>
    </div>

    <!-- Admin Form -->
    <form id="adminForm" action="AdminLogIn" method="post" class="login-form">
        <h3>Admin LogIn</h3>
        <label>Username:</label>
        <input type="text" name="email" required>
        <label>Password:</label>
        <div class="password-field">
            <input type="password" name="password" id="adminPassword" required>
            <label class="switch">
              <input type="checkbox" onclick="togglePassword('adminPassword')">
              <span class="slider"></span>											
            </label>
        </div>
        <button type="submit">Log In</button>
    </form>

    <!-- Resident Form -->
    <form id="residentForm" action="ResidentLogIn" method="post" class="login-form hidden-form">
        <h3>Resident LogIn</h3>
        <label>Username/Contact no:</label>
        <input type="text" name="contactID" minlength="10" maxlength="10" required>
        <label>Password:</label>
        <div class="password-field">
            <input type="password" name="password" id="residentPassword" required>
            <label class="switch">
              <input type="checkbox" onclick="togglePassword('residentPassword')">
              <span class="slider"></span>
            </label>
        </div>
        <button type="submit">Log In</button>
        <p>Don't have an account?</p><a href="resident_register">Register</a>
    </form>

    <!-- Installer Form -->
    <form id="installerForm" action="InstallerLogIn" method="post" class="login-form hidden-form">
        <h3>Installer LogIn</h3>
        <label>Username/Contact no:</label>
        <input type="text" name="contactID" minlength="10" maxlength="10" required>
        <label>Password:</label>
        <div class="password-field">
            <input type="password" name="password" id="installerPassword" required>
            <label class="switch">
              <input type="checkbox" onclick="togglePassword('installerPassword')">
              <span class="slider"></span>
            </label>
        </div>
        <button type="submit">Log In</button>
    </form>
</div>
<script >
function switchForm(formId) {
    // Hide all forms
    document.querySelectorAll('.login-form').forEach(form => {
        form.classList.add('hidden-form');
    });

    // Show the selected form
    document.getElementById(formId).classList.remove('hidden-form');

    // Update active button styling
    document.querySelectorAll('.form-toggle button').forEach(btn => {
        btn.classList.remove('active');
    });

    if (formId === 'adminForm') {
        document.getElementById('adminBtn').classList.add('active');
    } else if (formId === 'residentForm') {
        document.getElementById('residentBtn').classList.add('active');
    } else if (formId === 'installerForm') {
        document.getElementById('installerBtn').classList.add('active');
    }
}


</script>
</body>

</html>
