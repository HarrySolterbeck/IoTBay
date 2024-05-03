<%-- 
    Document   : home
    Created on : Apr 5, 2024, 4:53:59 PM
    Author     : JGPar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.iot.model.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        <h1>User profile</h1>
        <div class="home-page">
            <table id="profile_table">
            <thead><th>Name</th><th>Email</th><th>Password</th><th>DOB</th></thead>
            <tr><td>${user.name}</td><td>${user.email}</td><td>${user.password}</td><td>${user.dob}</td></tr>
            </table>
            <a href="welcome.jsp"><button>Back</button></a>
        </div>
        
    </body>
</html>
