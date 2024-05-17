<%-- 
    Document   : login
    Created on : Apr 12, 2024, 4:40:55 PM
    Author     : JGPar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css"/>
    </head>
    <body>
        <h1>Login</h1>
        <div class="login-form">
            <form action="welcome.jsp" method="post">
            <table>
                <tr><td>Email: </td><td><input type="text" name="email" placeholder="Enter email..." required="true"></td></tr>
                <tr><td>Password: </td><td><input type="password" name="pass" placeholder="Enter password..." required="true"></td></tr>
            </table>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset"><br>
            </form>
            <a href="index.jsp"><button>Cancel</button></a>
        </div>
        
    </body>
</html>
