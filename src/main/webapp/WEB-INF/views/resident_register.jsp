<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Resident Registration</title>
    <link rel="stylesheet" href="./resources/css/resident_register.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">
</head>
<body>

<div class="form-container">
    <form action="add_register" class="register-form">
        <h2>Resident Registration</h2>

        <label>Name :</label>
        <input type="text" name="rname" required>

        <label>Address :</label>
        <input type="text" name="raddress" required>

        <label>Email :</label>
        <input type="email" name="remail" required>

        <label>Contact :</label>
        <input type="text" name="rcontact" minlength="10" maxlength="10" required>

        <label>Adhar :</label>
        <input type="text" name="radhar" minlength="12" maxlength="12" required>

        <label>Password :</label>
        <input type="password" name="rpassword" required>

        <button type="submit">Register</button>
        <p><a href="index">Back To LogIN</a></p>
    </form>
</div>

</body>
</html>
