/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DataAccess.DAO.CustomerDAO;
import DataAccess.Entity.Customer;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author awake
 */

@Path("customers")
public class CustomersLoader extends Application{
    @GET
    @Path("list")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String CustomersLoader()throws Exception {
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Customer> customers = customerDAO.getAllCustomers();
        return new Gson().toJson(customers);
    }
}
