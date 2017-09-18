/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author awake
 */
@Entity
@Table(name = "available_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvailableProducts.findAll", query = "SELECT a FROM AvailableProducts a"),
    @NamedQuery(name = "AvailableProducts.findByProductId", query = "SELECT a FROM AvailableProducts a WHERE a.availableProductsPK.productId = :productId"),
    @NamedQuery(name = "AvailableProducts.findByCustomerId", query = "SELECT a FROM AvailableProducts a WHERE a.availableProductsPK.customerId = :customerId"),
    @NamedQuery(name = "AvailableProducts.findByPermitted", query = "SELECT a FROM AvailableProducts a WHERE a.permitted = :permitted")})
public class AvailableProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvailableProductsPK availableProductsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permitted")
    private boolean permitted;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public AvailableProducts() {
    }

    public AvailableProducts(AvailableProductsPK availableProductsPK) {
        this.availableProductsPK = availableProductsPK;
    }

    public AvailableProducts(AvailableProductsPK availableProductsPK, boolean permitted) {
        this.availableProductsPK = availableProductsPK;
        this.permitted = permitted;
    }

    public AvailableProducts(int productId, int customerId) {
        this.availableProductsPK = new AvailableProductsPK(productId, customerId);
    }

    public AvailableProductsPK getAvailableProductsPK() {
        return availableProductsPK;
    }

    public void setAvailableProductsPK(AvailableProductsPK availableProductsPK) {
        this.availableProductsPK = availableProductsPK;
    }

    public boolean getPermitted() {
        return permitted;
    }

    public void setPermitted(boolean permitted) {
        this.permitted = permitted;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (availableProductsPK != null ? availableProductsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvailableProducts)) {
            return false;
        }
        AvailableProducts other = (AvailableProducts) object;
        if ((this.availableProductsPK == null && other.availableProductsPK != null) || (this.availableProductsPK != null && !this.availableProductsPK.equals(other.availableProductsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.AvailableProducts[ availableProductsPK=" + availableProductsPK + " ]";
    }
    
}
