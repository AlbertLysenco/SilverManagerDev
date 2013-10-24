/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author albert
 */
@Entity
@Table(name = "ST_CONTRACTS", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contracts.findAll", query = "SELECT c FROM Contracts c"),
    @NamedQuery(name = "Contracts.findByContractId", query = "SELECT c FROM Contracts c WHERE c.contractId = :contractId"),
    @NamedQuery(name = "Contracts.findByContractNumber", query = "SELECT c FROM Contracts c WHERE c.contractNumber = :contractNumber"),
    @NamedQuery(name = "Contracts.findByContractDate", query = "SELECT c FROM Contracts c WHERE c.contractDate = :contractDate")})
public class Contracts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONTRACT_ID", nullable = false)
    private Integer contractId;
    @Column(name = "CONTRACT_NUMBER", length = 100)
    private String contractNumber;
    @Column(name = "CONTRACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date contractDate;
    @OneToMany(mappedBy = "contractId", fetch = FetchType.LAZY)
    private Collection<Services> servicesCollection;

    public Contracts() {
    }

    public Contracts(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @XmlTransient
    public Collection<Services> getServicesCollection() {
        return servicesCollection;
    }

    public void setServicesCollection(Collection<Services> servicesCollection) {
        this.servicesCollection = servicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractId != null ? contractId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contracts)) {
            return false;
        }
        Contracts other = (Contracts) object;
        if ((this.contractId == null && other.contractId != null) || (this.contractId != null && !this.contractId.equals(other.contractId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Contracts[ contractId=" + contractId + " ]";
    }
    
}
