/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

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
    
}
