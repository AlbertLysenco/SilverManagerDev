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
@Table(name = "ST_MANAGERS", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Managers.findAll", query = "SELECT m FROM Managers m"),
    @NamedQuery(name = "Managers.findByManagerId", query = "SELECT m FROM Managers m WHERE m.managerId = :managerId"),
    @NamedQuery(name = "Managers.findByManagerFirstName", query = "SELECT m FROM Managers m WHERE m.managerFirstName = :managerFirstName"),
    @NamedQuery(name = "Managers.findByManagerLastName", query = "SELECT m FROM Managers m WHERE m.managerLastName = :managerLastName"),
    @NamedQuery(name = "Managers.findByManagerFathersName", query = "SELECT m FROM Managers m WHERE m.managerFathersName = :managerFathersName"),
    @NamedQuery(name = "Managers.findByManagerSpace", query = "SELECT m FROM Managers m WHERE m.managerSpace = :managerSpace"),
    @NamedQuery(name = "Managers.findByManagerPhone", query = "SELECT m FROM Managers m WHERE m.managerPhone = :managerPhone"),
    @NamedQuery(name = "Managers.findByManagerPhoneS1", query = "SELECT m FROM Managers m WHERE m.managerPhoneS1 = :managerPhoneS1"),
    @NamedQuery(name = "Managers.findByManagerPhoneS2", query = "SELECT m FROM Managers m WHERE m.managerPhoneS2 = :managerPhoneS2"),
    @NamedQuery(name = "Managers.findByManagerStatus", query = "SELECT m FROM Managers m WHERE m.managerStatus = :managerStatus")})
public class Managers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MANAGER_ID", nullable = false)
    private Integer managerId;
    @Column(name = "MANAGER_FIRST_NAME", length = 70)
    private String managerFirstName;
    @Column(name = "MANAGER_LAST_NAME", length = 70)
    private String managerLastName;
    @Column(name = "MANAGER_FATHERS_NAME", length = 70)
    private String managerFathersName;
    @Column(name = "MANAGER_SPACE", length = 70)
    private String managerSpace;
    @Column(name = "MANAGER_PHONE")
    private Integer managerPhone;
    @Column(name = "MANAGER_PHONE_S1")
    private Integer managerPhoneS1;
    @Column(name = "MANAGER_PHONE_S2")
    private Integer managerPhoneS2;
    @Column(name = "MANAGER_STATUS", length = 70)
    private String managerStatus;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private Collection<Clients> clientsCollection;

    public Managers() {
    }

    public Managers(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getManagerFathersName() {
        return managerFathersName;
    }

    public void setManagerFathersName(String managerFathersName) {
        this.managerFathersName = managerFathersName;
    }

    public String getManagerSpace() {
        return managerSpace;
    }

    public void setManagerSpace(String managerSpace) {
        this.managerSpace = managerSpace;
    }

    public Integer getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(Integer managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Integer getManagerPhoneS1() {
        return managerPhoneS1;
    }

    public void setManagerPhoneS1(Integer managerPhoneS1) {
        this.managerPhoneS1 = managerPhoneS1;
    }

    public Integer getManagerPhoneS2() {
        return managerPhoneS2;
    }

    public void setManagerPhoneS2(Integer managerPhoneS2) {
        this.managerPhoneS2 = managerPhoneS2;
    }

    public String getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(String managerStatus) {
        this.managerStatus = managerStatus;
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
        hash += (managerId != null ? managerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Managers)) {
            return false;
        }
        Managers other = (Managers) object;
        if ((this.managerId == null && other.managerId != null) || (this.managerId != null && !this.managerId.equals(other.managerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Managers[ managerId=" + managerId + " ]";
    }
    
}
