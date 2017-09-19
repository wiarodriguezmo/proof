/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Product;

/**
 *
 * @author awake
 */
public class OrderDetailDAO {

    public String createOrderDetail(int orderId, Integer productId, Product product) {
        String respuestaSQL = CrudDAO.update("INSERT INTO order_detail (order_id, product_id, price, product_description) VALUES (?, ?, ?, ?);",
                        new String[]{
                                Integer.toString(orderId),
                                Integer.toString(productId),
                                Integer.toString(product.getPrice()),
                                product.getProductDescr()
                        }
        );
        System.out.println("UsuarioDAO.update: " + respuestaSQL);
        return respuestaSQL;
    }
    
}
