package Partner;

import Entities.Partner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PartnerModel extends AbstractTableModel {
    
    List<Partner> list = new ArrayList<>();

    Connection c;
    
    public PartnerModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectPartner(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectPartner(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 4;
    
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
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getName();
            case 1:
                return list.get(rowIndex).getAgent();
            case 2:
                return list.get(rowIndex).getPhone_number();
            case 3:
                return list.get(rowIndex).getAddress();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "name";
            case 1:
                return "agent";
            case 2:
                return "phone_number";
            case 3:
                return "address";
        }
        return null;
    }

    public Partner getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Partner> selectPartner(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Partner> partners = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Partner");
            while (rs.next()) {
                Partner item = new Partner(rs.getInt("ID"), rs.getString("Name"), 
                        rs.getString("Agent"), rs.getString("Phone_number"), 
                        rs.getString("Address"));

                partners.add(item);
            }
            return partners;
    }
    
    public static Partner selectPartnerById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Partner WHERE id = "+id );
        Partner partner = null;
        while (rs.next()) {
           partner = new Partner(rs.getInt("ID"), rs.getString("Name"), 
                    rs.getString("Agent"), rs.getString("Phone_number"), 
                    rs.getString("Address"));
        }
        return partner;
    }
    public void insertOrUpdate(Partner editItem, String name, String agent, String phone_number, String address) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Partner "
                    + "(name,agent,Phone_number,Address) "
                    + "values ('"
                    + name + "','" + agent
                    + "','" + phone_number + "','"
                    + address + "');");
            } else {
                statement.executeUpdate("update Partner set first_name='"
                    + name + "',agent='"
                    + agent +
                    "',phone_number='" + phone_number + "',address="
                    + address + " where ID="
                    + editItem.getID() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Partner where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
