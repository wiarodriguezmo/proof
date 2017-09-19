/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author awake
 */
public class ProductDAO {
 
    public ArrayList<Integer> getProductsAvailablePerCustomer(String ID) throws Exception {
        ArrayList<Integer> productsAvailable = new ArrayList<Integer>();
        ResultSet rs = CrudDAO.query("SELECT product_id FROM available_products WHERE customer_id=?", new String[]{ID});
        try {
                while (rs.next()) { 
                    productsAvailable.add(rs.getInt("product_id"));
                }
                return productsAvailable;
        } catch (SQLException e) {
                System.out.println("ProductDAO.getByID: " + e.getMessage());
                return new ArrayList<Integer>();
        }
    }
    
    
    public Product getByID(String ID) throws Exception {
        ResultSet rs = CrudDAO.query("SELECT * FROM product WHERE product_id =?", new String[]{ID});
        try {
                rs.first();
                Product ue = toEntity(rs);
                return ue;
        } catch (SQLException e) {
                System.out.println("CustomerDAO.getByID: " + e.getMessage());
                return new Product();
        }
    }
    
    protected Product toEntity(ResultSet rs) throws SQLException {
        return new Product(
            rs.getInt("product_id"),
            rs.getString("name"),
            rs.getString("product_description"),
            rs.getInt("price")
        );
    }
}
