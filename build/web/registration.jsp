<%-- 
    Document   : registration
    Created on : Mar 22, 2024, 4:31:16 PM
    Author     : JGPar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="uts.iot.connection.ConnectionDB"%>
<% ConnectionDB db = new ConnectionDB();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="css/registration.css"/>
    </head>
    <body>
        <h1>Register</h1>
        <div class="registration-page">
            <form action="welcome.jsp" method="post">
            <table>
                <tr><td>Full Name: </td><td><input type="text" name="name" placeholder="Enter name..." required="true"></td></tr>
                <tr><td>Date of birth: </td><td><input type="date" name="dob" placeholder="DD/MM/YYYY" required="true"></td></tr>
                <tr><td>Email: </td><td><input type="text" name="email" placeholder="Enter email..." required="true"></td></tr>
                <tr><td>Password: </td><td><input type="password" name="pass" placeholder="Enter password..." required="true"></td></tr>
                <tr><td>Terms of Service: </td><td><label for="yes"><input type="radio" name="tos" required></input>Agree</label>
                                                   <label for="no"><input type="radio" name="tos" required></input>Disagree</label></td></tr>
            </table>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset"><br>
            <a href="index.jsp"><button>Cancel</button></a>
        </form>
            
            
            <%= db.getCon() %>
        </div>
        
    </body>
</html>
