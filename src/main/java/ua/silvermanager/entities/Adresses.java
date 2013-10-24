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
@Table(name = "ST_ADRESSES", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresses.findAll", query = "SELECT a FROM Adresses a"),
    @NamedQuery(name = "Adresses.findByAdressId", query = "SELECT a FROM Adresses a WHERE a.adressId = :adressId"),
    @NamedQuery(name = "Adresses.findByAdressCity", query = "SELECT a FROM Adresses a WHERE a.adressCity = :adressCity"),
    @NamedQuery(name = "Adresses.findByAdressStreet", query = "SELECT a FROM Adresses a WHERE a.adressStreet = :adressStreet"),
    @NamedQuery(name = "Adresses.findByAdressHouseNumber", query = "SELECT a FROM Adresses a WHERE a.adressHouseNumber = :adressHouseNumber")})
public class Adresses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADRESS_ID", nullable = false)
    private Integer adressId;
    @Column(name = "ADRESS_CITY", length = 100)
    private String adressCity;
    @Column(name = "ADRESS_STREET", length = 100)
    private String adressStreet;
    @Column(name = "ADRESS_HOUSE_NUMBER")
    private Integer adressHouseNumber;
    @OneToMany(mappedBy = "adressId", fetch = FetchType.LAZY)
    private Collection<Clients> clientsCollection;

    public Adresses() {
    }

    public Adresses(Integer adressId) {
        this.adressId = adressId;
    }

    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }

    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public Integer getAdressHouseNumber() {
        return adressHouseNumber;
    }

    public void setAdressHouseNumber(Integer adressHouseNumber) {
        this.adressHouseNumber = adressHouseNumber;
    }

    @XmlTransient
    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adressId != null ? adressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresses)) {
            return false;
        }
        Adresses other = (Adresses) object;
        if ((this.adressId == null && other.adressId != null) || (this.adressId != null && !this.adressId.equals(other.adressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Adresses[ adressId=" + adressId + " ]";
    }
    
}
