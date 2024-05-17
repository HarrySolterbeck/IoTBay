
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.iot.model.User"%>
<%@page import="java.sql.Date"%>
<%@page import="uts.iot.connection.ConnectionDB"%>
<%@page import="java.text.SimpleDateFormat"%>
<% ConnectionDB db = new ConnectionDB();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <link rel="stylesheet" href="css/welcome.css"/>
    </head>
    <body>
        <%
    Integer customerId = (Integer) session.getAttribute("CustomerID");
    if (customerId == null) {
        // No CustomerID found in session, redirect to login page
        response.sendRedirect("login.jsp");
    }
%>
        <%
            String UserName = request.getParameter("UserName");
            String email = request.getParameter("email");
            String FName = request.getParameter("FName");
            String LName = request.getParameter("LName");
            String Address = request.getParameter("Address");
            String City = request.getParameter("City");
            String PostCode = request.getParameter("PostCode");
            String PhoneNum = request.getParameter("PhoneNum");
            String PWord = request.getParameter("PWord");
            String Gender = request.getParameter("Gender");
            String dobStr = request.getParameter("DOB");
            Date dob = null;
            try {
                dob = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dobStr).getTime());
            } catch (Exception e) {
            }
        %>

               
       
        <%
            User user = new User(UserName, email, FName, LName, Address, City, PostCode, PhoneNum, PWord, Gender, dob);
            user.setUserName(UserName);
            user.setEmail(email);
            user.setFName(FName);
            user.setLName(LName);
            user.setAddress(Address);
            user.setCity(City);
            user.setPostCode(PostCode);
            user.setPhoneNum(PhoneNum);
            user.setPWord(PWord);
            user.setGender(Gender);
            user.setDOB(dob);
            session.setAttribute("user", user);
        %>
        
         <h1>Welcome <%=UserName %></h1>
        <div class="welcome-page">
            
            <p>Your name is <%= LName%> <%= FName%></p><br>
            <p>Your date of birth is <%= dob %></p><br>
            <p>Your email is <%= email %></p><br>
            <p>Your password is <%= PWord %></p><br>
            <a href="home.jsp"><button>Main</button></a>
            <a href="index.jsp"><button>Logout page</button></a>
        </div>
    </body>
</html>
