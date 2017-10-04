/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author gbwd
 */
public class Role {
    private int id;
    private String role;
    private int salary;
    
    public Role(int id, String role, int salary){
        this.id = id;
        this.role = role;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return getRole();
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;    
    }
    
    public int getSalary(){
        return salary;
    }
    
    public void setSalary(int salary){
        this.salary = salary;
    }
    
}
