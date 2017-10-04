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
public class Section {
    private int number;
    private int capacity;
    
    public Section(int number, int capacity){
        this.number = number;
        this.capacity = capacity;
    }
    
    @Override
    public String toString() {
        return Integer.toString(getNumber());
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;    
    }
    
}
