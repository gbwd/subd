 package Product;

import Entities.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
 
public class ProductModel extends AbstractTableModel {
    
    List<Product> list = new ArrayList<>();

    Connection c;
    
    public ProductModel(Connection c) throws SQLException {
        super();
        this.c = c;
        list = selectProduct(c);
        rowsCount = list.size();
    }

    public void updateData() throws SQLException {
        list = new ArrayList<>();
        list = selectProduct(c);
        rowsCount = list.size();
    }
    
    int rowsCount = 5;
    int colCount = 1;
    
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
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "name";
        }
        return null;
    }

    public Product getSelectesItem(int row) {
        return list.get(row);
    }

    public static List<Product> selectProduct(Connection c) throws SQLException{
        Statement statement = c.createStatement();
        List<Product> products = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Product");
            while (rs.next()) {
                Product item = new Product(rs.getInt("ID"), rs.getString("Name"));

                products.add(item);
            }
            return products;
    }
    
    public static Product selectProductById(Connection c, int id) throws SQLException{
    Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Product WHERE id = "+id );
        Product product = null;
        while (rs.next()) {
           product = new Product(rs.getInt("ID"), rs.getString("Name"));
        }
        return product;
    }
    public void insertOrUpdate(Product editItem, String name) {
        try {
            Statement statement = c.createStatement();
            if (editItem == null) {
                statement.executeUpdate("insert into Product "+ "(name) "+ "values ('"+ name + "');");
            } else {
                statement.executeUpdate("update Product set name='"+ name + ";");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    } 
    
    public void delete(int id){
        try {
                Statement statement = c.createStatement();
                statement.executeUpdate("delete from Product where ID="
                    + id + ";");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
    }
}
