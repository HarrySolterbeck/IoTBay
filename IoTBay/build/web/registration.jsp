<%-- 
    Document   : registration
    Created on : Mar 22, 2024, 4:31:16 PM
    Author     : JGPar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="uts.iot.model.User, uts.iot.connection.ConnectionDB"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="css/registration.css"/>
    </head>
    <body>
        <h1>Register New User</h1>
        <form action="RegisterUserServlet" method="post">
            <p>User Name: <input type="text" name="userName" required /></p>
            <p>Email: <input type="email" name="email" required /></p>
            <p>First Name: <input type="text" name="fName" required /></p>
            <p>Last Name: <input type="text" name="lName" required /></p>
            <p>Address: <input type="text" name="address" /></p>
            <p>City: <input type="text" name="city" /></p>
            <p>Post Code: <input type="text" name="postCode" /></p>
            <p>Phone Number: <input type="text" name="phoneNum" /></p>
            <p>Password: <input type="password" name="pWord" required /></p>
            <p>Gender: <input type="text" name="gender" /></p>
            <p>Date of Birth: <input type="date" name="dob" /></p>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
