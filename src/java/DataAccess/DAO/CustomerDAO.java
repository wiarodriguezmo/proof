/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author williamvision
 */
public class CustomerDAO extends CrudDAO<Customer> {
    
    public CustomerDAO(){
    }
    
    public Customer getByID(String ID) throws Exception {
        ResultSet rs = CrudDAO.query("SELECT * FROM customer WHERE customer_id =?", new String[]{ID});
        try {
                rs.first();
                Customer ue = toEntity(rs);

                return ue;
        } catch (SQLException e) {
                System.out.println("CustomerDAO.getByID: " + e.getMessage());
                return new Customer();
        }
    }
    
    public ArrayList<Customer> getAllCustomers() throws Exception {
        ArrayList<Customer> customers = new ArrayList<>();
        ResultSet rs = CrudDAO.query("SELECT * FROM customer", new String[]{});
        try {
                while (rs.next()) { 
                    customers.add(getByID(Integer.toString(rs.getInt("customer_id"))));
                }
                return customers;
        } catch (SQLException e) {
                System.out.println("CustomerDAO.getByID: " + e.getMessage());
                return new ArrayList<Customer>();
        }
    }
    
    @Override
    protected Customer toEntity(ResultSet rs) throws SQLException {
        return new Customer(
            rs.getInt("customer_id"),
            rs.getString("name"),
            rs.getString("email")
        );
    }

    @Override
    protected Class getEntityClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
