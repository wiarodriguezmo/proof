/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			System.out.println("TallerDAO.getByID: " + e.getMessage());
			return new Customer();
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
