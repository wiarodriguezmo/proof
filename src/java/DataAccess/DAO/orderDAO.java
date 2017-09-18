/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Order;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author awake
 */
public class orderDAO {
    public Order persist(Order order) {
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
}
