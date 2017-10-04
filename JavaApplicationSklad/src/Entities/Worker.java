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
public class Worker {
    private int id;
    private String firstName;
    private String surname;
    private String patronymic;
    private int role_id;
    
    public Worker(int id, String firstName, String surname, String patronymic, int role_id){
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.role_id = role_id;
    }
    
    @Override
    public String toString() {
        return getSurname();
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;    
    }
    
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;    
    }
    
    public String getPatronymic(){
        return patronymic;
    }
    
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;    
    }
    
     public int getRole_id(){
        return role_id;
    }
    
    public void setRole_id(int id){
        this.role_id = id;
    }
}
