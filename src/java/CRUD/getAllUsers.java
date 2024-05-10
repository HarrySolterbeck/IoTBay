/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import uts.iot.connection.ConnectionDB;
import uts.iot.model.User;
import java.sql.*;

/**
 *
 * @author Joshua
 */

public List<User> getAllUsers(){
    List<User> users = new ArrayList<>();
    String query = "SELECT * FROM User";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            User user = new User(rs.getInt("CustomerID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("FName"), rs.getString("LName"), rs.getString("Address"), rs.getString("City"), rs.getString("PostCode"), rs.getString("PhoneNum"), rs.getString("PWord"), rs.getString("Gender"), rs.getString("DOB"));
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}
