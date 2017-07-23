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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mrx
 */
@Entity
@Table(name = "database_changed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatabaseChanged.findAll", query = "SELECT d FROM DatabaseChanged d"),
    @NamedQuery(name = "DatabaseChanged.findById", query = "SELECT d FROM DatabaseChanged d WHERE d.id = :id"),
    @NamedQuery(name = "DatabaseChanged.findByTimeUnix", query = "SELECT d FROM DatabaseChanged d WHERE d.timeUnix = :timeUnix")})
public class DatabaseChanged implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Time_Unix")
    private long timeUnix;

    public DatabaseChanged() {
    }

    public DatabaseChanged(Integer id) {
        this.id = id;
    }

    public DatabaseChanged(Integer id, long timeUnix) {
        this.id = id;
        this.timeUnix = timeUnix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTimeUnix() {
        return timeUnix;
    }

    public void setTimeUnix(long timeUnix) {
        this.timeUnix = timeUnix;
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
        if (!(object instanceof DatabaseChanged)) {
            return false;
        }
        DatabaseChanged other = (DatabaseChanged) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DatabaseChanged[ id=" + id + " ]";
    }
    
}
