package Worker;

import Entities.Worker;
import Entities.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class WorkerModel extends AbstractTableModel {
    
    List<Worker> list = new ArrayList<>();

    Connection c;
    
    public WorkerModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectWorker(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectWorker(c);
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
        String s = "";
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getFirstName();
            case 1:
                return list.get(rowIndex).getSurname();
            case 2:
                return list.get(rowIndex).getPatronymic();
            case 3:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM role "
                            + "where id=" + list.get(rowIndex).getRole_id() 
                            + ";");
                    rs.next();
                    s = rs.getString("role");
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
                return "first_name";
            case 1:
                return "surname";
            case 2:
                return "patronymic";
            case 3:
                return "role";
        }
        return null;
    }

    public Worker getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Worker> selectWorker(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Worker> workers = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Worker");
            while (rs.next()) {
                Worker item = new Worker(rs.getInt("ID"), rs.getString("First_name"), 
                        rs.getString("Surname"), rs.getString("Patronymic"), 
                        rs.getInt("Role_id"));

                workers.add(item);
            }
            return workers;
    }
    
    
    public void insertOrUpdate(Worker editItem, String name, String surname, String patronymic, int role) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into worker "
                    + "(first_name,surname,patronymic,role_id) "
                    + "values ('"
                    + name + "','" + surname
                    + "','" + patronymic + "','"
                    + role + "');");
            } else {
                statement.executeUpdate("update worker set first_name='"
                    + name + "',surname='"
                    + surname +
                    "',patronymic='" + patronymic + "',role_id="
                    + role + " where ID="
                    + editItem.getID() + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Worker where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
