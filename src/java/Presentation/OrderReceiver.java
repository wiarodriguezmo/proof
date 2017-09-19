/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import java.util.Date;
import BusinessLogic.OrderHandler;
import DataAccess.DAO.OrderDAO;
import DataAccess.Entity.Orde;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author awake
 */

@ApplicationPath("webresources")
@Path("orders")
public class OrderReceiver extends Application{
        
    @POST
    @Path("create")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public void createOrder(String data)throws Exception {
        JSONObject objRequest = (JSONObject)new JSONParser().parse(data);
        JSONArray selectedProducts = (JSONArray)objRequest.get("selectedProducts");
        Integer customerId = ((Long)objRequest.get("id")).intValue();
        Integer deliveryAddress = ((Long)objRequest.get("deliveryAddress")).intValue();
        
        ArrayList<Integer> products = new ArrayList<Integer>();  
        if (selectedProducts != null) {
           int len = selectedProducts.size();
           for (int i=0;i<len;i++){ 
                JSONObject json = (JSONObject)selectedProducts.get(i);
                products.add(((Long)json.get("productId")).intValue());
           } 
        }
        
        OrderHandler orderHandler = new OrderHandler(customerId, deliveryAddress, products);
        orderHandler.createOrder();
    }
    
    @GET
    @Path("/list")
    public String listByDate(@QueryParam("customerId") String customerId, @QueryParam("before") Long before, @QueryParam("after") Long after)throws Exception {
        OrderDAO orderDAO = new OrderDAO(); 
        Date beforeDate = Date.from(Instant.ofEpochSecond(before));
        Date afterDate = Date.from(Instant.ofEpochSecond(after));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeQ = sdf.format(beforeDate);
        String afterQ = sdf.format(afterDate);
        ArrayList<Orde> orders = orderDAO.getAllOrders(customerId, beforeQ, afterQ);
        return new Gson().toJson(orders);  
    }
}

