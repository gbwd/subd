
package ReceptionReg;

import Entities.ReceptionReg;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ReceptionRegModel extends AbstractTableModel {
    
    List<ReceptionReg> list = new ArrayList<>();

    Connection c;
    
    public ReceptionRegModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectReceptionReg(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectReceptionReg(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 7;
    
    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getDate();
            case 1:
                return list.get(rowIndex).getQuantity();
            case 2:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM section "
                            + "where number=" + list.get(rowIndex).getSection_number() 
                            + ";");
                    rs.next();
                    s = rs.getString("number");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 3:
                return list.get(rowIndex).getPrice();
            case 4:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM partner "
                            + "where id=" + list.get(rowIndex).getPartner_id() 
                            + ";");
                    rs.next();
                    s = rs.getString("name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 5:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM product "
                            + "where id=" + list.get(rowIndex).getProduct_id() 
                            + ";");
                    rs.next();
                    s = rs.getString("name");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 6:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM worker "
                            + "where id=" + list.get(rowIndex).getWorker_id() 
                            + ";");
                    rs.next();
                    s = rs.getString("surname");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "date";
            case 1:
                return "quantity";
            case 2:
                return "section";
            case 3:
                return "price";
            case 4:
                return "partner";
            case 5:
                return "product";
            case 6:
                return "worker";
        }
        return null;
    }

    public ReceptionReg getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<ReceptionReg> selectReceptionReg(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<ReceptionReg> registration_of_receptions = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Registration_of_reception");
            while (rs.next()) {
                ReceptionReg item = new ReceptionReg(rs.getInt("ID"), rs.getString("Date_of_receipt"), 
                        rs.getInt("Quantity"), rs.getInt("Section_number"), 
                        rs.getInt("Price"), rs.getInt("Partner_id"), rs.getInt("Product_id"), rs.getInt("Worker_id"));

                registration_of_receptions.add(item);
            }
            return registration_of_receptions;
    }
    
    public static ReceptionReg selectReceptionRegById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Registration_of_reception WHERE id = "+id );
        ReceptionReg registration_of_reception = null;
        while (rs.next()) {
           registration_of_reception = new ReceptionReg(rs.getInt("ID"), rs.getString("Date_of_receipt"), 
                        rs.getInt("Quantity"), rs.getInt("Section_number"), 
                        rs.getInt("Price"), rs.getInt("Partner_id"), rs.getInt("Product_id"), rs.getInt("Worker_id"));
        }
        return registration_of_reception;
    }
    
    public void insertOrUpdate(ReceptionReg editItem, String date, int quantity, int section_number,
            int price, int partner_id, int product_id, int worker_id) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Registration_of_reception "
                    + "(date_of_receipt,quantity,section_number,Price,partner_id,product_id,"
                    + "worker_id) "
                    + "values ('"
                    + date + "','" + quantity
                    + "','"
                    + section_number + "','"
                    + price + "','"
                    + partner_id + "','"
                    + product_id + "','"
                    + worker_id + "');");
            } else {
                statement.executeUpdate("update Registration_of_reception set date_of_receipt='"
                    + date + "',quantity='" + quantity
                    +"',section_number=" + section_number                        
                    +",price=" + price
                    + ",partner_id=" +partner_id
                    + ",product_id=" +product_id
                    + ",worker_id=" + worker_id
                    + " where ID=" + editItem.getID() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Registration_of_reception where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
