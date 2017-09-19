/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Customer;
import DataAccess.Entity.Orde;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author awake
 */
public class OrderDAO {
    
    public Orde persist(Orde order) {
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("beitechPU");
	em = emf.createEntityManager();

	em.getTransaction().begin();
	try {
	  em.persist(order);
	  em.getTransaction().rollback();
	} catch (Exception e) {
	  em.getTransaction().rollback();
	} finally {
	  em.close();
	  return order;
	}
    }    

    public static String create(Orde order) {
        String respuestaSQL = CrudDAO.update("INSERT INTO orde (order_id, delivery_address, customer_id) VALUES (null, ?, ?);",
                        new String[]{
                                Integer.toString(order.getDeliveryAddress()),
                                Integer.toString(order.getCustomerId().getCustomerId())
                        }
        );
        System.out.println("UsuarioDAO.update: " + respuestaSQL);
        return respuestaSQL;
    }
    
    public Integer getMax() throws Exception {
        ResultSet rs = CrudDAO.query("SELECT MAX(order_id) as Max FROM orde", new String[]{});
        try {
                rs.first();
                return rs.getInt("Max");

        } catch (SQLException e) {
                System.out.println("CustomerDAO.getByID: " + e.getMessage());
                return 0;
        }
    }
}
