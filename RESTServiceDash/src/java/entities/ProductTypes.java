/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mrx
 */
@Entity
@Table(name = "product_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductTypes.findAll", query = "SELECT p FROM ProductTypes p"),
    @NamedQuery(name = "ProductTypes.findByPId", query = "SELECT p FROM ProductTypes p WHERE p.pId = :pId"),
    @NamedQuery(name = "ProductTypes.findByName", query = "SELECT p FROM ProductTypes p WHERE p.name = :name"),
    @NamedQuery(name = "ProductTypes.findByAmount", query = "SELECT p FROM ProductTypes p WHERE p.amount = :amount")})
public class ProductTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PId")
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private int amount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<ProductDetail> productDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<ProductDetailLast25> productDetailLast25Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<Sales> salesCollection;

    public ProductTypes() {
    }

    public ProductTypes(Integer pId) {
        this.pId = pId;
    }

    public ProductTypes(Integer pId, String name, int amount) {
        this.pId = pId;
        this.name = name;
        this.amount = amount;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<ProductDetail> getProductDetailCollection() {
        return productDetailCollection;
    }

    public void setProductDetailCollection(Collection<ProductDetail> productDetailCollection) {
        this.productDetailCollection = productDetailCollection;
    }

    @XmlTransient
    public Collection<ProductDetailLast25> getProductDetailLast25Collection() {
        return productDetailLast25Collection;
    }

    public void setProductDetailLast25Collection(Collection<ProductDetailLast25> productDetailLast25Collection) {
        this.productDetailLast25Collection = productDetailLast25Collection;
    }

    @XmlTransient
    public Collection<Sales> getSalesCollection() {
        return salesCollection;
    }

    public void setSalesCollection(Collection<Sales> salesCollection) {
        this.salesCollection = salesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductTypes)) {
            return false;
        }
        ProductTypes other = (ProductTypes) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductTypes[ pId=" + pId + " ]";
    }
    
}
