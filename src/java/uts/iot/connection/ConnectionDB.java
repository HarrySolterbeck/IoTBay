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
    public static Connection getCon() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/users?zeroDateTimeBehavior=CONVERT_TO_NULL","root","L3g3nd211");
    }
}
