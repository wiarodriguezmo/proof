/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import DataAccess.DAO.CustomerDAO;
import DataAccess.DAO.OrderDAO;
import DataAccess.DAO.OrderDetailDAO;
import DataAccess.DAO.ProductDAO;
import DataAccess.Entity.Customer;
import DataAccess.Entity.Orde;
import DataAccess.Entity.Product;
import java.util.ArrayList;;

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
        if(products.size()>0){
            Orde order = new Orde();
            order.setDeliveryAddress(2);
            //Customer customer = new Customer(1, "will", "yp@as.co");
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.getByID(Integer.toString(customerId));
            order.setCustomerId(customer);


            OrderDAO orderDAO = new OrderDAO();
            String orderResp = orderDAO.create(order);
            
            int orderId = orderDAO.getMax();
            
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            ProductDAO productDAO = new ProductDAO();
            
            for(Integer temp : products){
                Product product = productDAO.getByID(Integer.toString(temp));
                System.out.println(orderDetailDAO.createOrderDetail(orderId, temp, product));
            }
        }
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
    
    private static class AddCustomersRequest {

        public AddCustomersRequest() {
        }
    }
}
