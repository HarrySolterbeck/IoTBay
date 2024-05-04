/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import uts.iot.connection.ConnectionDB;
import java.sql.Connection;

/**
 *
 * @author Joshua
 */
public class InsertLogin {
    
    
    public void insertLogin(){
        ConnectionDB loginConnection = new ConnectionDB();
        connection loginConnection.getCon();
        
        
        ConnectionDB obj_DB_Connection = new ConnectionDB();
        Connection connection=obj_DB_Connection.getCon();
        
        String query="insert into User("name,DOB,email,pWord")";
}       
    
    
}   
