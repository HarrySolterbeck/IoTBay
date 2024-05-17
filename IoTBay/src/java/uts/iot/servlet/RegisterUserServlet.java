/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package uts.iot.servlet;
import uts.iot.connection.ConnectionDB;
import uts.iot.model.User;
import CRUD.InsertUser;
import java.io.IOException;
import java.sql.Date;




/**
 *
 * @author Joshua
 */
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postCode = request.getParameter("postCode");
        String phoneNum = request.getParameter("phoneNum");
        String pWord = request.getParameter("pWord");
        String gender = request.getParameter("gender");
        Date dob = Date.valueOf(request.getParameter("dob"));

        User user = new User(userName, email, fName, lName, address, city, postCode, phoneNum, pWord, gender, dob);
        new InsertUser().insertUser(user);
        
        HttpSession session = request.getSession();
        session.setAttribute("CustomerID", user.getCustomerID());
        session.setAttribute("user", user);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        //response.sendRedirect("welcome.jsp");
    }
