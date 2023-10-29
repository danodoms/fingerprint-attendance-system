/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class Position {
    private int position_id;
    private String position_name;
    private String position_description;
    private int department_ID;
    
    public Position (int position_id, String position_name){
        this.position_id = position_id;
        this.position_name = position_name;
    }
    
    public Position(String position_name){
        this.position_name = position_name;
    }
    
    @Override
    public String toString() {
        return position_name;
    }

    public int getId() {
        return position_id;
    }

    public void setId(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_description() {
        return position_description;
    }

    public void setPosition_description(String position_description) {
        this.position_description = position_description;
    }

    public int getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        this.department_ID = department_ID;
    }
    
}