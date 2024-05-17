package CRUD;

import uts.iot.connection.ConnectionDB;
import uts.iot.model.User;
import java.sql.*;


public class GetUser {

    public User getUserById(int customerId) {
        User user = null;
        String query = "SELECT * FROM User WHERE CustomerID = ?";
        try (Connection conn = ConnectionDB.getCon();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setCustomerID(rs.getInt("CustomerID"));
                user.setUserName(rs.getString("UserName"));
                user.setEmail(rs.getString("Email"));
                user.setFName(rs.getString("FName"));
                user.setLName(rs.getString("LName"));
                user.setAddress(rs.getString("Address"));
                user.setCity(rs.getString("City"));
                user.setPostCode(rs.getString("PostCode"));
                user.setPhoneNum(rs.getString("PhoneNum"));
                user.setPWord(rs.getString("PWord"));
                user.setGender(rs.getString("Gender"));
                user.setDOB(rs.getDate("DOB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
