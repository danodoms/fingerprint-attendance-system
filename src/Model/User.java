/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author admin
 */
public class User {
    private int id;
    private String password;
    private String email;
    private String address;
    private String user_fname;
    private String user_lname;
    private String user_mname;
    private String suffix;
    private String user_type;
    private int user_cntct;
    private int user_status;
    private byte[] user_img;
    
    
    
          public static int getNextUserId(){
        int nextUserId = 1;
        try (Connection connection = dbMethods.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT user_id from user order by user_id desc limit 1");
            
            if (rs.next()) {
                nextUserId = rs.getInt("user_id")+1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextUserId;
        
    }
          
    public static ObservableList<User> getUserByUserId(int userId){
        ObservableList<User> users = FXCollections.observableArrayList();

        try (Connection connection = dbMethods.getConnection();
            Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM user WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                  users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("password"),
                        rs.getString("email"),
                          rs.getString("address"),
                          rs.getString("user_fname"),
                          rs.getString("user_lname"),
                          rs.getString("user_mname"),
                          rs.getString("suffix"),
                          rs.getString("user_type"),
                          rs.getInt("user_cntct"),
                          rs.getInt("user_status"),
                          rs.getBytes("user_img")
                          
                          
                  ));
            }

             System.out.println(users);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User(int id, String password, String email, String address, String user_fname, String user_lname, String user_mname, String suffix, String user_type, int user_cntct, int user_status, byte[] user_img) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.address = address;
        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_mname = user_mname;
        this.suffix = suffix;
        this.user_type = user_type;
        this.user_cntct = user_cntct;
        this.user_status = user_status;
        this.user_img = user_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_fname() {
        return user_fname;
    }

    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public String getUser_mname() {
        return user_mname;
    }

    public void setUser_mname(String user_mname) {
        this.user_mname = user_mname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public int getUser_cntct() {
        return user_cntct;
    }

    public void setUser_cntct(int user_cntct) {
        this.user_cntct = user_cntct;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }

    public byte[] getUser_img() {
        return user_img;
    }

    public void setUser_img(byte[] user_img) {
        this.user_img = user_img;
    }
    
}
