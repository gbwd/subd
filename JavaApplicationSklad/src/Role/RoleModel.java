
package Role;

import Entities.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RoleModel extends AbstractTableModel {
    
    List<Role> list = new ArrayList<>();

    Connection c;
    
    public RoleModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectRole(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectRole(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 2;
    
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
                return list.get(rowIndex).getRole();
            case 1:
                return list.get(rowIndex).getSalary();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "role";
            case 1:
                return "salary";
        }
        return null;
    }

    public Role getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Role> selectRole(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Role> roles = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Role");
            while (rs.next()) {
                Role item = new Role(rs.getInt("ID"), rs.getString("Role"), 
                        rs.getInt("Salary"));

                roles.add(item);
            }
            return roles;
    }
    
    public static Role selectRoleById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Role WHERE id = "+id );
        Role role = null;
        while (rs.next()) {
           role = new Role(rs.getInt("ID"), rs.getString("Role"), 
                    rs.getInt("Salary"));
        }
        return role;
    }
    public void insertOrUpdate(Role editItem, String role, int salary) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into role "
                    + "(role,salary) "+ "values ('"+ role + "','" + salary+  "');");
            } else {
                statement.executeUpdate("update role set role='"+ role + "',salary='"+ salary +";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from role where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}

