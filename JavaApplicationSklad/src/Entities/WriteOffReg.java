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
public class WriteOffReg {
    private int id;
    private String write_off_date;
    private int quantity;
    private int section_number;
    private int partner_id;
    private int product_id;
    private int worker_id;
    
    public WriteOffReg(int id, String write_off_date, 
            int quantity, int section_number, int partner_id, 
            int product_id, int worker_id){
        this.id = id;
        this.write_off_date = write_off_date;
        this.quantity = quantity;
        this.section_number  = section_number;
        this.partner_id = partner_id;
        this.product_id = product_id;
        this.worker_id = worker_id;
    }
    
    @Override
    public String toString() {
        return getDate();
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getDate(){
        return write_off_date;
    }
    
    public void setDate(String write_off_date){
        this.write_off_date = write_off_date;    
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getSection_number(){
        return section_number;
    }
    
    public void setSection_number(int section_number){
        this.section_number = section_number;
    }
    
    public int getPartner_id(){
        return partner_id;
    }
    
    public void setPartner_id(int partner_id){
        this.partner_id = partner_id;
    }
    
    public int getProduct_id(){
        return product_id;
    }
    
    public void setProduct_id(int product_id){
        this.product_id = product_id;
    }
    
    public int getWorker_id(){
        return worker_id;
    }
    
    public void setWorker_id(int worker_id){
        this.worker_id = worker_id;
    }
}
