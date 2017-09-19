/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DAO.CustomerDAO;
import DataAccess.DAO.OrderDAO;
import DataAccess.DAO.ProductDAO;
import DataAccess.Entity.Customer;
import DataAccess.Entity.Order;
import DataAccess.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author awake
 */

public class OrderHandler  {
    Integer customerId;
    ArrayList<Integer> products;

    public OrderHandler(Integer customerId, ArrayList<Integer> products) {
        this.customerId = customerId;
        this.products = products;
    }
    
    public void createOrder()throws Exception {
        products = validProductsOnOrder();
        
        Order order = new Order(1);
        order.setDeliveryAddress(2);
        //Customer customer = new Customer(1, "will", "yp@as.co");
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getByID(Integer.toString(customerId));
        order.setCustomerId(customer);
        
        OrderDAO orderDAO = new OrderDAO();
        Order orderE = orderDAO.persist(order);
        System.out.println(orderE.toString());
    }
    
    private ArrayList<Integer> validProductsOnOrder() throws Exception{
        ArrayList<Integer> availableProducts, newProducts = new ArrayList<Integer>();
        ProductDAO productDAO = new ProductDAO();
        availableProducts = productDAO.getProductsAvailablePerCustomer(customerId.toString());
        for(Integer temp : availableProducts){
            if(products.contains(temp))
                newProducts.add(temp);
        }
        return newProducts;
    }
    
    
    /*
    public Customer getCustomerFromId(Integer customerId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customID");
        
        EntityManager em = emf.createEntityManager();
        TypedQuery consultaCustomer = em.createNamedQuery("seleccionarAlumnosNombre", Alumno.class);
consultaAlumnos.setParameter("nombre", "miguel");
List<Alumno> lista= consultaAlumnos.getResultList();
        
        System.out.println("B " + customerId);
        Customer customer = new Customer();
        customer.findByCustomerId(1);
        System.out.println(em.createNamedQuery("findByCustomerId")
        .setParameter("customerId", 1)
        .getResultList());
        //System.out.println("AA " + customer.hashCode());
        return null;
    }
    public String createOrder(@Valid RequestObj requestObj){
        if(invalidProductsOnOrder(requestObj))return "NO";
        Order order = new Order();
        System.out.println(requestObj);
        return "SI";
    }
    */
    
    @GET
    @Path("/s")
    public String proof(){
        System.out.println("siii");
        return "sii";
        
    }

    private static class AddCustomersRequest {

        public AddCustomersRequest() {
        }
    }
}
