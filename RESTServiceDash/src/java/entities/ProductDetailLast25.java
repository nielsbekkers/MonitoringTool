/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mrx
 */
@Entity
@Table(name = "product_detail_last_25")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetailLast25.findAll", query = "SELECT p FROM ProductDetailLast25 p"),
    @NamedQuery(name = "ProductDetailLast25.findById", query = "SELECT p FROM ProductDetailLast25 p WHERE p.id = :id"),
    @NamedQuery(name = "ProductDetailLast25.findBySerialNumber", query = "SELECT p FROM ProductDetailLast25 p WHERE p.serialNumber = :serialNumber"),
    @NamedQuery(name = "ProductDetailLast25.findByTimeUnix", query = "SELECT p FROM ProductDetailLast25 p WHERE p.timeUnix = :timeUnix"),
    @NamedQuery(name = "ProductDetailLast25.findByProperty1", query = "SELECT p FROM ProductDetailLast25 p WHERE p.property1 = :property1"),
    @NamedQuery(name = "ProductDetailLast25.findByProperty2", query = "SELECT p FROM ProductDetailLast25 p WHERE p.property2 = :property2"),
    @NamedQuery(name = "ProductDetailLast25.findByProperty3", query = "SELECT p FROM ProductDetailLast25 p WHERE p.property3 = :property3")})
public class ProductDetailLast25 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Serial_Number")
    private String serialNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Time_Unix")
    private long timeUnix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Property_1")
    private String property1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Property_2")
    private String property2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Property_3")
    private String property3;
    @JoinColumn(name = "PId", referencedColumnName = "PId")
    @ManyToOne(optional = false)
    private ProductTypes pId;

    public ProductDetailLast25() {
    }

    public ProductDetailLast25(Integer id) {
        this.id = id;
    }

    public ProductDetailLast25(Integer id, String serialNumber, long timeUnix, String property1, String property2, String property3) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.timeUnix = timeUnix;
        this.property1 = property1;
        this.property2 = property2;
        this.property3 = property3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getTimeUnix() {
        return timeUnix;
    }

    public void setTimeUnix(long timeUnix) {
        this.timeUnix = timeUnix;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

    public ProductTypes getPId() {
        return pId;
    }

    public void setPId(ProductTypes pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetailLast25)) {
            return false;
        }
        ProductDetailLast25 other = (ProductDetailLast25) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductDetailLast25[ id=" + id + " ]";
    }
    
}
