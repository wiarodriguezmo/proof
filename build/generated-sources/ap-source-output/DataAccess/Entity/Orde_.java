package DataAccess.Entity;

import DataAccess.Entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-19T06:32:38")
@StaticMetamodel(Orde.class)
public class Orde_ { 

    public static volatile SingularAttribute<Orde, Integer> orderId;
    public static volatile SingularAttribute<Orde, Integer> deliveryAddress;
    public static volatile SingularAttribute<Orde, Customer> customerId;

}