
package WriteOffReg;

import Entities.WriteOffReg;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class WriteOffRegModel extends AbstractTableModel {
    
    List<WriteOffReg> list = new ArrayList<>();

    Connection c;
    
    public WriteOffRegModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectWriteOffReg(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectWriteOffReg(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 6;
    
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
            case 4:
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
            case 5:
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
                return "partner";
            case 4:
                return "product";
            case 5:
                return "worker";
        }
        return null;
    }

    public WriteOffReg getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<WriteOffReg> selectWriteOffReg(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<WriteOffReg> write_off_registrations = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Write_off_registration");
            while (rs.next()) {
                WriteOffReg item = new WriteOffReg(rs.getInt("ID"), rs.getString("Write_off_date"), 
                        rs.getInt("Quantity"), rs.getInt("Section_number"), 
                         rs.getInt("Partner_id"), rs.getInt("Product_id"), rs.getInt("Worker_id"));

                write_off_registrations.add(item);
            }
            return write_off_registrations;
    }
    
    public static WriteOffReg selectWriteOffRegById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Write_off_registration WHERE id = "+id );
        WriteOffReg write_off_registration = null;
        while (rs.next()) {
           write_off_registration = new WriteOffReg(rs.getInt("ID"), rs.getString("Write_off_date"), 
                        rs.getInt("Quantity"), rs.getInt("Section_number"), 
                         rs.getInt("Partner_id"), rs.getInt("Product_id"), rs.getInt("Worker_id"));
        }
        return write_off_registration;
    }
    
    public void insertOrUpdate(WriteOffReg editItem, String date, int quantity, int section_number,
            int partner_id, int product_id, int worker_id) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Write_off_registration "
                    + "(write_off_date,quantity,section_number,partner_id,product_id,"
                    + "worker_id) "
                    + "values ('"
                    + date + "','" + quantity
                    + "','"
                    + section_number + "','"
                    + partner_id + "','"
                    + product_id + "','"
                    + worker_id + "');");
            } else {
                statement.executeUpdate("update Write_off_registration set write_off_date='"
                    + date + "',quantity='"
                    + quantity+
                    "',section_number="
                    + section_number
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
                statement.executeUpdate("delete from Write_off_registration where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
