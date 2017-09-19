package DataAccess.Entity;

import DataAccess.Entity.Orde;
import DataAccess.Entity.OrderDetailPK;
import DataAccess.Entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-19T06:32:38")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Product> product;
    public static volatile SingularAttribute<OrderDetail, Integer> price;
    public static volatile SingularAttribute<OrderDetail, Orde> order1;
    public static volatile SingularAttribute<OrderDetail, OrderDetailPK> orderDetailPK;
    public static volatile SingularAttribute<OrderDetail, String> productDescription;

}