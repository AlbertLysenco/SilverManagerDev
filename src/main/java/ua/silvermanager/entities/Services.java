/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author albert
 */
@Entity
@Table(name = "ST_SERVICES", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByServiceId", query = "SELECT s FROM Services s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Services.findByServiceAdress", query = "SELECT s FROM Services s WHERE s.serviceAdress = :serviceAdress")})
public class Services implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SERVICE_ID", nullable = false)
    private Integer serviceId;
    @Column(name = "SERVICE_ADRESS", length = 255)
    private String serviceAdress;
    @OneToMany(mappedBy = "serviceId", fetch = FetchType.LAZY)
    private Collection<Clients> clientsCollection;
    @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "CONTRACT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contracts contractId;

    public Services() {
    }

    public Services(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceAdress() {
        return serviceAdress;
    }

    public void setServiceAdress(String serviceAdress) {
        this.serviceAdress = serviceAdress;
    }

    @XmlTransient
    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
    }

    public Contracts getContractId() {
        return contractId;
    }

    public void setContractId(Contracts contractId) {
        this.contractId = contractId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Services[ serviceId=" + serviceId + " ]";
    }
    
}
