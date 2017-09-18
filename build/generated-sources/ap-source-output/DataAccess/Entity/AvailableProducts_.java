package DataAccess.Entity;

import DataAccess.Entity.AvailableProductsPK;
import DataAccess.Entity.Customer;
import DataAccess.Entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-17T23:00:46")
@StaticMetamodel(AvailableProducts.class)
public class AvailableProducts_ { 

    public static volatile SingularAttribute<AvailableProducts, Product> product;
    public static volatile SingularAttribute<AvailableProducts, AvailableProductsPK> availableProductsPK;
    public static volatile SingularAttribute<AvailableProducts, Boolean> permitted;
    public static volatile SingularAttribute<AvailableProducts, Customer> customer;

}