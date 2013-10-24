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
import javax.persistence.Lob;
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
@Table(name = "ST_STAGES", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stages.findAll", query = "SELECT s FROM Stages s"),
    @NamedQuery(name = "Stages.findByStageId", query = "SELECT s FROM Stages s WHERE s.stageId = :stageId"),
    @NamedQuery(name = "Stages.findByStageName", query = "SELECT s FROM Stages s WHERE s.stageName = :stageName"),
    @NamedQuery(name = "Stages.findByStageStatus", query = "SELECT s FROM Stages s WHERE s.stageStatus = :stageStatus"),
    @NamedQuery(name = "Stages.findByStageAvailableTime", query = "SELECT s FROM Stages s WHERE s.stageAvailableTime = :stageAvailableTime")})
public class Stages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STAGE_ID", nullable = false)
    private Integer stageId;
    @Column(name = "STAGE_NAME", length = 100)
    private String stageName;
    @Column(name = "STAGE_STATUS", length = 50)
    private String stageStatus;
    @Column(name = "STAGE_AVAILABLE_TIME", length = 30)
    private String stageAvailableTime;
    @Lob
    @Column(name = "STAGE_DESCRIPTION", length = 65535)
    private String stageDescription;
    @JoinColumn(name = "EQUIPMENT_ID", referencedColumnName = "EQUIPMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Equipment equipmentId;
    @JoinColumn(name = "STAGE_CONTACT_ID", referencedColumnName = "STAGE_CONTACT_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StageContacts stageContactId;
    @OneToMany(mappedBy = "stageId", fetch = FetchType.LAZY)
    private Collection<Clients> clientsCollection;

    public Stages() {
    }

    public Stages(Integer stageId) {
        this.stageId = stageId;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageStatus() {
        return stageStatus;
    }

    public void setStageStatus(String stageStatus) {
        this.stageStatus = stageStatus;
    }

    public String getStageAvailableTime() {
        return stageAvailableTime;
    }

    public void setStageAvailableTime(String stageAvailableTime) {
        this.stageAvailableTime = stageAvailableTime;
    }

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public StageContacts getStageContactId() {
        return stageContactId;
    }

    public void setStageContactId(StageContacts stageContactId) {
        this.stageContactId = stageContactId;
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
        hash += (stageId != null ? stageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stages)) {
            return false;
        }
        Stages other = (Stages) object;
        if ((this.stageId == null && other.stageId != null) || (this.stageId != null && !this.stageId.equals(other.stageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Stages[ stageId=" + stageId + " ]";
    }
    
}
