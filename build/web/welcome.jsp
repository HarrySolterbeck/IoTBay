
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.iot.model.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <link rel="stylesheet" href="css/welcome.css"/>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
      
        %>
        <h1>Welcome <%= name %></h1>
        <div class="welcome-page">
            
            <p>Your name is <%= name %></p><br>
            <p>Your date of birth is <%= dob %></p><br>
            <p>Your email is <%= email %></p><br>
            <p>Your password is <%= password %></p><br>
            <a href="home.jsp"><button>Main</button></a>
            <a href="index.jsp"><button>Logout page</button></a>
        </div>
        <%
            User user = new User(name, email, password, dob);
            user.setName(name);
            user.setDob(dob);
            user.setEmail(email);
            user.setPassword(password);
            session.setAttribute("user", user);
        %>
    </body>
</html>
