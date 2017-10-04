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
public class Partner {
    private int id;
    private String name;
    private String agent;
    private String phone_number;
    private String address;
    
    public Partner(int id, String name, String agent, String phone_number, String address){
        this.id = id;
        this.name = name;
        this.agent = agent;
        this.phone_number = phone_number;
        this.address = address;               
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;    
    }
    
    public String getAgent(){
        return agent;
    }
    
    public void setAgent(String agent){
        this.agent = agent;
    }
    
    public String getPhone_number(){
        return phone_number;
    }
    
    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
}
    

