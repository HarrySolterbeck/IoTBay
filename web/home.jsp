<%-- 
    Document   : home
    Created on : Apr 5, 2024, 4:53:59 PM
    Author     : JGPar
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.iot.model.User"%>
<%@page import="CRUD.GetUser"%>
<%@page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
       <%
            // Assuming CustomerID is stored in session when user logs in or registers
            Integer customerId = (Integer) session.getAttribute("CustomerID");
            GetUser getUser = new GetUser();
            User user = null;
            if (customerId != null) {
                user = getUser.getUserById(customerId);
            }
            
            if (user == null) {
                out.println("<h2>User not found. Please log in again.</h2>");%>
                <a href="index.jsp">Home Page</a>
            <%    // Redirect to login or error page
            } else {
        %>
        <h1>User profile</h1>
        <div class="home-page">
            <table id="profile_table">
                <thead><th>Name</th><th>Email</th><th>Password</th><th>DOB</th></thead>
                <tbody>
                    <tr>
                        <td><%= user.getFName() %> <%= user.getLName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getPWord() %></td> <!-- Consider security implications of showing password -->
                        <td><%= new SimpleDateFormat("yyyy-MM-dd").format(user.getDOB()) %></td>
                    </tr>
                </tbody>
            </table>
            <a href="welcome.jsp"><button>Back</button></a>
        </div>
        <% 
            } // Closing else block
        %>
    </body>
</html>
