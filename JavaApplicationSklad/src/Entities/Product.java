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
public class Product {
    private int id;
    private String name;
    
    public Product(int id, String name){
        this.id = id;
        this.name = name;
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
}
