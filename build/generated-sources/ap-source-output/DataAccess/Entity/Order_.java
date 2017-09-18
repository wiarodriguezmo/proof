package DataAccess.Entity;

import DataAccess.Entity.Customer;
import DataAccess.Entity.OrderDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-17T23:00:46")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile CollectionAttribute<Order, OrderDetail> orderDetailCollection;
    public static volatile SingularAttribute<Order, Integer> orderId;
    public static volatile SingularAttribute<Order, Integer> deliveryAddress;
    public static volatile SingularAttribute<Order, Customer> customerId;

}