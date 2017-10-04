package Section;

import Entities.Section;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class SectionModel extends AbstractTableModel {
    
    List<Section> list = new ArrayList<>();

    Connection c;
    
    public SectionModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectSection(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectSection(c);
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
                return list.get(rowIndex).getNumber();
            case 1:
                return list.get(rowIndex).getCapacity();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "number";
            case 1:
                return "capacity";
        }
        return null;
    }

    public Section getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Section> selectSection(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Section> sections = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Section");
            while (rs.next()) {
                Section item = new Section(rs.getInt("Number"), rs.getInt("Capacity"));

                sections.add(item);
            }
            return sections;
    }
    
    public static Section selectSectionById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Section WHERE id = "+id );
        Section section = null;
        while (rs.next()) {
           section = new Section(rs.getInt("Number"), rs.getInt("Capacity"));
        }
        return section;
    }
    
    public void insertOrUpdate(Section editItem, String capacity) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into section "
                    + "(capacity) "+ "values ('"+ capacity + "');");
            } else {
                statement.executeUpdate("update section set capacity='"
                    + capacity + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int num){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from section where number="
                    + num + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
    
}
