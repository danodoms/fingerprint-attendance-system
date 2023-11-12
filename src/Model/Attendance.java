/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.dbMethods;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class Attendance {
    private Date date;
    private String attendance_status;
    private String timeIn;
    private String timeOut;
    private String name;
    private String deptName;
    private String notation;
    public static String defaultValue = "All";
    
     public Attendance (String name, Date date, String timeIn, String timeOut, String notation, String attendance_status){
        this.name = name;
        this.date = date;
        this.attendance_status = attendance_status;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.notation = notation;
    }
      public String getName() {
        return name;
    }
      public String getNotation() {
        return notation;
    }
       public String getDeptName() {
        return deptName;
    }
     public Date getDate() {
        return date;
    }
     public String getAttendance_status() {
        return attendance_status;
    }
     public String getTimeIn() {
        return timeIn;
    }
     public String getTimeOut() {
        return timeOut;
    }
    
     
     
public void setName(String name) {
    this.name = name;
}

public void setNotation(String notation) {
    this.notation = notation;
}

public void setDeptName(String deptName) {
    this.deptName = deptName;
}

public void setDate(Date date) {
    this.date = date;
}

public void setAttendance_status(String attendance_status) {
    this.attendance_status = attendance_status;
}

public void setTimeIn(String timeIn) {
    this.timeIn = timeIn;
}

public void setTimeOut(String timeOut) {
    this.timeOut = timeOut;
}
        public static ObservableList<Attendance> getAttendance(){
        ObservableList<Attendance> attendance = FXCollections.observableArrayList();
        try (Connection connection = dbMethods.getConnection();
            Statement statement = connection.createStatement()){
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(u.user_fname, ' ', u.user_lname) AS name, c.date, "
            + "c.time_in as timeIn, c.time_out as timeOut, c.time_notation as notation, c.attendance_status \n" +
            "FROM attendance c \n" +
            "JOIN user u ON c.user_id = u.user_id "+
            "JOIN assignment a ON u.user_id = a.user_id " +
            "JOIN position p ON a.position_id = p.position_id " +
            "JOIN department d ON p.department_id = d.department_id " +
            "WHERE u.user_status = 1 GROUP BY c.attendance_id ORDER BY c.attendance_id;");
            //d.department_id = 1 && 
            while (rs.next()) {
                int statusInt = rs.getInt("attendance_status");
                String out= rs.getString("timeOut");
                String statusString;
                String time_out;

                   if(out.equals("00:00:00")){
                       out = " ";
                   }

                if (statusInt == 1) {
                    statusString = "   ♥";
                } else if (statusInt == 2) {
                    statusString = "Late";
                } else if (statusInt == 3) {
                    statusString = "No Out";
                } else {
                    statusString = "Unknown";
                }

                attendance.add(new Attendance(
                    rs.getString("name"),
                    rs.getDate("date"),
                  rs.getString("timeIn"),
                 out,
                rs.getString("notation"), 
         statusString
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    }
        
         public static ObservableList<Attendance> getAdministrative(){
        ObservableList<Attendance> attendance = FXCollections.observableArrayList();
        try (Connection connection = dbMethods.getConnection();
            Statement statement = connection.createStatement()){
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(u.user_fname, ' ', u.user_lname) AS name, c.date, "
            + "c.time_in as timeIn, c.time_out as timeOut, c.time_notation as notation, c.attendance_status \n" +
            "FROM attendance c \n" +
            "JOIN user u ON c.user_id = u.user_id "+
            "JOIN assignment a ON u.user_id = a.user_id " +
            "JOIN position p ON a.position_id = p.position_id " +
            "JOIN department d ON p.department_id = d.department_id " +
            "WHERE d.department_id = 1 && u.user_status = 1 GROUP BY c.attendance_id ORDER BY c.attendance_id;");
            //d.department_id = 1 && 
            while (rs.next()) {
                int statusInt = rs.getInt("attendance_status");
                String out= rs.getString("timeOut");
                String statusString;
                String time_out;

                   if(out.equals("00:00:00")){
                       out = " ";
                   }

                if (statusInt == 1) {
                    statusString = "   ♥";
                } else if (statusInt == 2) {
                    statusString = "Late";
                } else if (statusInt == 3) {
                    statusString = "No Out";
                } else {
                    statusString = "Unknown";
                }

                attendance.add(new Attendance(
                    rs.getString("name"),
                    rs.getDate("date"),
                  rs.getString("timeIn"),
                 out,
                rs.getString("notation"),
         statusString
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    } 
         
         public static ObservableList<Attendance> getInstruction(){
        ObservableList<Attendance> attendance = FXCollections.observableArrayList();
        try (Connection connection = dbMethods.getConnection();
            Statement statement = connection.createStatement()){
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(u.user_fname, ' ', u.user_lname) AS name, c.date, "
            + "c.time_in as timeIn, c.time_out as timeOut, c.time_notation as notation, c.attendance_status \n" +
            "FROM attendance c \n" +
            "JOIN user u ON c.user_id = u.user_id "+
            "JOIN assignment a ON u.user_id = a.user_id " +
            "JOIN position p ON a.position_id = p.position_id " +
            "JOIN department d ON p.department_id = d.department_id " +
            "WHERE d.department_id = 2 && u.user_status = 1 GROUP BY c.attendance_id ORDER BY c.attendance_id;");
            //d.department_id = 1 && 
            while (rs.next()) {
                int statusInt = rs.getInt("attendance_status");
                String out= rs.getString("timeOut");
                String statusString;
                String time_out;

                   if(out.equals("00:00:00")){
                       out = " ";
                   }

                if (statusInt == 1) {
                    statusString = "   ♥";
                } else if (statusInt == 2) {
                    statusString = "Late";
                } else if (statusInt == 3) {
                    statusString = "No Out";
                } else {
                    statusString = "Unknown";
                }

                attendance.add(new Attendance(
                    rs.getString("name"),
                    rs.getDate("date"),
                  rs.getString("timeIn"),
                 out, 
            rs.getString("notation"),
         statusString
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    }
        
        public static ObservableList<Attendance> getAttendancebyDate(){
        ObservableList<Attendance> attendance = FXCollections.observableArrayList();
        try (Connection connection = dbMethods.getConnection();
            Statement statement = connection.createStatement()){
            
            ResultSet rs = statement.executeQuery("SELECT CONCAT(u.user_fname, ' ', u.user_lname) AS name, c.date, "
            + "c.time_in as timeIn, c.time_out as timeOut, c.time_notation as notation, c.attendance_status \n" +
            "FROM attendance c \n" +
            "JOIN user u ON c.user_id = u.user_id "+
            "JOIN assignment a ON u.user_id = a.user_id " +
            "JOIN position p ON a.position_id = p.position_id " +
            "JOIN department d ON p.department_id = d.department_id " +
            "WHERE u.user_status = 1 GROUP BY c.attendance_id ORDER BY c.attendance_id;");
            
            while (rs.next()) {
                int statusInt = rs.getInt("attendance_status");
                String in = rs.getString("timeIn");
                String out= rs.getString("timeOut");
                String statusString;
                String time_out;

                   if(out.equals("00:00:00")){
                       out = " ";
                   }

                if (statusInt == 1) {
                    statusString = "  √";
                } else if (statusInt == 2) {
                    statusString = "Late";
                } else if (statusInt == 3) {
                    statusString = "No Out";
                } else {
                    statusString = "Unknown";
                }

                attendance.add(new Attendance(
                    rs.getString("name"),
                    rs.getDate("date"),
                  rs.getString("timeIn"),
                 out, 
                 rs.getString("notation"),
         statusString
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendance;
    }
}
