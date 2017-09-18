/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.Entity.Order;
import DataAccess.Entity.Product;
import java.util.List;
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
        System.out.println("Sierve");
        
        JSONArray recoData = (JSONArray)new JSONParser().parse(data);
        System.out.println(recoData.get(1));
        //System.out.println("name=" + recoData.get("name"));
        //System.out.println("width=" + recoData.get("width"));
    }
    
    /*
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
