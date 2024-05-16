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
public class InsertUser {
    
    
    public void insertUser(User user){
        
        String query = "INSERT INTO User ( UserName, Email, FName, LName, Address, City, PostCode, PhoneNum, PWord, Gender, DOB) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection conn = ConnectionDB.getCon();
                PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getFName());
                ps.setString(4, user.getLName());
                ps.setString(5, user.getAddress());
                ps.setString(6, user.getCity());
                ps.setString(7, user.getPostCode());
                ps.setString(8, user.getPhoneNum());
                ps.setString(9, user.getPWord());
                ps.setString(10, user.getGender());
                ps.setDate(11, user.getDOB());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}