package BusinessLogic;

import DataAccess.Entity.Product;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awake
 */
public class RequestObj {
   
  private ArrayList<Product> products;
  private Integer customerId ;

  public void setValues(ArrayList<Product> products, Integer customerId) {
      this.products = products;
      this.customerId = customerId;
  }
 
  public ArrayList<Product> getProducts() {
     return this.products;
  }

  public Integer getCustomerId() {
     return this.customerId;
  }
}