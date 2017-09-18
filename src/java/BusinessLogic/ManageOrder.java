/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DAO.CustomerDAO;
import DataAccess.DAO.OrderDAO;
import DataAccess.Entity.Customer;
import DataAccess.Entity.Order;
import DataAccess.Entity.Product;
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
//@ApplicationPath("webresources")
@ApplicationPath("webresources")
@Path("orders")
public class ManageOrder extends Application {
    
    @POST
    @Path("create")
    //@Consumes("application/json")
    
    //@Consumes({MediaType.APPLICATION_JSON})
    
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public void createOrder(String data)throws Exception {        
        JSONArray recoData = (JSONArray)new JSONParser().parse(data);
        JSONObject json = (JSONObject) recoData.get(1);
        System.out.println(json.get("name"));
        //System.out.println("name=" + recoData.get("name"));
        //System.out.println("width=" + recoData.get("width"));
        
        Order order = new Order(1);
        order.setDeliveryAddress(2);
        Customer customer = new Customer(1, "will", "yp@as.co");
        order.setCustomerId(customer);
        System.out.println("Segundo");
        //order.setCustomerId();
        
        //OrderDAO orderDAO = new OrderDAO();
        //Order orderE = orderDAO.persist(order);
        
        CustomerDAO customerDAO = new CustomerDAO();
        Customer prueba = customerDAO.getByID("1");
        System.out.println(prueba.getName());
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
    
    private boolean invalidProductsOnOrder(RequestObj requestObj){
        return false;
    }
    
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
