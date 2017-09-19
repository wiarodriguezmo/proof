/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BusinessLogic.OrderHandler;
import java.util.ArrayList;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
        
        ArrayList<Integer> products = new ArrayList<Integer>();  
        if (selectedProducts != null) {
           int len = selectedProducts.size();
           for (int i=0;i<len;i++){ 
                JSONObject json = (JSONObject)selectedProducts.get(i);
                products.add(((Long)json.get("productId")).intValue());
           } 
        }
        
        OrderHandler orderHandler = new OrderHandler(customerId, products);
        orderHandler.createOrder();
        
    }
}
