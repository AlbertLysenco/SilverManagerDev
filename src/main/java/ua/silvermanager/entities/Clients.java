/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author albert
 */
@Entity
@Table(name = "ST_CLIENTS", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByClientId", query = "SELECT c FROM Clients c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Clients.findByClientFullName", query = "SELECT c FROM Clients c WHERE c.clientFullName = :clientFullName"),
    @NamedQuery(name = "Clients.findByClientDirName", query = "SELECT c FROM Clients c WHERE c.clientDirName = :clientDirName"),
    @NamedQuery(name = "Clients.findByClientStatus", query = "SELECT c FROM Clients c WHERE c.clientStatus = :clientStatus"),
    @NamedQuery(name = "Clients.findByClientDateOn", query = "SELECT c FROM Clients c WHERE c.clientDateOn = :clientDateOn"),
    @NamedQuery(name = "Clients.findByClientDateOff", query = "SELECT c FROM Clients c WHERE c.clientDateOff = :clientDateOff"),
    @NamedQuery(name = "Clients.findByClientPhoneS", query = "SELECT c FROM Clients c WHERE c.clientPhoneS = :clientPhoneS"),
    @NamedQuery(name = "Clients.findByClientPhoneBuh", query = "SELECT c FROM Clients c WHERE c.clientPhoneBuh = :clientPhoneBuh"),
    @NamedQuery(name = "Clients.findByClientPhoneDir", query = "SELECT c FROM Clients c WHERE c.clientPhoneDir = :clientPhoneDir"),
    @NamedQuery(name = "Clients.findByClientPhoneIt", query = "SELECT c FROM Clients c WHERE c.clientPhoneIt = :clientPhoneIt"),
    @NamedQuery(name = "Clients.findByClientFax", query = "SELECT c FROM Clients c WHERE c.clientFax = :clientFax"),
    @NamedQuery(name = "Clients.findByClientEmail", query = "SELECT c FROM Clients c WHERE c.clientEmail = :clientEmail"), 
    @NamedQuery(name = "Clients.findAllWhithDetails", query = "SELECT c FROM Clients c left join fetch c.managerId m")})
public class Clients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;
    @Column(name = "CLIENT_FULL_NAME", length = 100)
    private String clientFullName;
    @Column(name = "CLIENT_DIR_NAME", length = 100)
    private String clientDirName;
    @Column(name = "CLIENT_STATUS", length = 22)
    private String clientStatus;
    @Column(name = "CLIENT_DATE_ON")
    @Temporal(TemporalType.DATE)
    private Date clientDateOn;
    @Column(name = "CLIENT_DATE_OFF")
    @Temporal(TemporalType.DATE)
    private Date clientDateOff;
    @Column(name = "CLIENT_PHONE_S")
    private Integer clientPhoneS;
    @Column(name = "CLIENT_PHONE_BUH")
    private Integer clientPhoneBuh;
    @Column(name = "CLIENT_PHONE_DIR")
    private Integer clientPhoneDir;
    @Column(name = "CLIENT_PHONE_IT")
    private Integer clientPhoneIt;
    @Column(name = "CLIENT_FAX")
    private Integer clientFax;
    @Column(name = "CLIENT_EMAIL", length = 100)
    private String clientEmail;
    @Lob
    @Column(name = "CLIENT_DESCRIPTION", length = 65535)
    private String clientDescription;
    @JoinColumn(name = "STAGE_ID", referencedColumnName = "STAGE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stages stageId;
    @JoinColumn(name = "ADRESS_ID", referencedColumnName = "ADRESS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresses adressId;
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Services serviceId;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "MANAGER_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Managers managerId;

    public Clients() {
    }

    public Clients(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getClientDirName() {
        return clientDirName;
    }

    public void setClientDirName(String clientDirName) {
        this.clientDirName = clientDirName;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Date getClientDateOn() {
        return clientDateOn;
    }

    public void setClientDateOn(Date clientDateOn) {
        this.clientDateOn = clientDateOn;
    }

    public Date getClientDateOff() {
        return clientDateOff;
    }

    public void setClientDateOff(Date clientDateOff) {
        this.clientDateOff = clientDateOff;
    }

    public Integer getClientPhoneS() {
        return clientPhoneS;
    }

    public void setClientPhoneS(Integer clientPhoneS) {
        this.clientPhoneS = clientPhoneS;
    }

    public Integer getClientPhoneBuh() {
        return clientPhoneBuh;
    }

    public void setClientPhoneBuh(Integer clientPhoneBuh) {
        this.clientPhoneBuh = clientPhoneBuh;
    }

    public Integer getClientPhoneDir() {
        return clientPhoneDir;
    }

    public void setClientPhoneDir(Integer clientPhoneDir) {
        this.clientPhoneDir = clientPhoneDir;
    }

    public Integer getClientPhoneIt() {
        return clientPhoneIt;
    }

    public void setClientPhoneIt(Integer clientPhoneIt) {
        this.clientPhoneIt = clientPhoneIt;
    }

    public Integer getClientFax() {
        return clientFax;
    }

    public void setClientFax(Integer clientFax) {
        this.clientFax = clientFax;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientDescription() {
        return clientDescription;
    }

    public void setClientDescription(String clientDescription) {
        this.clientDescription = clientDescription;
    }

    public Stages getStageId() {
        return stageId;
    }

    public void setStageId(Stages stageId) {
        this.stageId = stageId;
    }

    public Adresses getAdressId() {
        return adressId;
    }

    public void setAdressId(Adresses adressId) {
        this.adressId = adressId;
    }

    public Services getServiceId() {
        return serviceId;
    }

    public void setServiceId(Services serviceId) {
        this.serviceId = serviceId;
    }

    public Managers getManagerId() {
        return managerId;
    }

    public void setManagerId(Managers managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Clients[ clientId=" + clientId + " ]";
    }
    
}
