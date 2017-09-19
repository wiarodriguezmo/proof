/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

/**
 *
 * @author awake
 */
public class ProductObj {
    private String productId;
    String name;
    
    public void getProductId(){
        
        System.out.println(this.toString());
    }
    
    public String getName(){
        return this.name;
    }
}
