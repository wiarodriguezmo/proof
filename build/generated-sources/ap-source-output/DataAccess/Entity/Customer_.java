package DataAccess.Entity;

import DataAccess.Entity.AvailableProducts;
import DataAccess.Entity.Orde;
import javax.annotation.Generated;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-19T06:32:38")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile CollectionAttribute<Customer, Orde> order1Collection;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, EntityManager> em;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile CollectionAttribute<Customer, AvailableProducts> availableProductsCollection;

}