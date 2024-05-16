/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.iot.connection;

import java.sql.*;
/**
 *
 * @author Joshua
 */
public class ConnectionDB {
    public static Connection getCon() {
        Connection Conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false","root","L3g3nd211");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Conn;
    }
}
