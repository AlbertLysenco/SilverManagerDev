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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ST_EQUIPMENT", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e"),
    @NamedQuery(name = "Equipment.findByEquipmentId", query = "SELECT e FROM Equipment e WHERE e.equipmentId = :equipmentId"),
    @NamedQuery(name = "Equipment.findByEqType", query = "SELECT e FROM Equipment e WHERE e.eqType = :eqType"),
    @NamedQuery(name = "Equipment.findByEqVlanAvailable", query = "SELECT e FROM Equipment e WHERE e.eqVlanAvailable = :eqVlanAvailable"),
    @NamedQuery(name = "Equipment.findByEqDateBouth", query = "SELECT e FROM Equipment e WHERE e.eqDateBouth = :eqDateBouth"),
    @NamedQuery(name = "Equipment.findByEqStatus", query = "SELECT e FROM Equipment e WHERE e.eqStatus = :eqStatus")})
public class Equipment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EQUIPMENT_ID", nullable = false)
    private Integer equipmentId;
    @Column(name = "EQ_TYPE", length = 22)
    private String eqType;
    @Column(name = "EQ_VLAN_AVAILABLE")
    private Integer eqVlanAvailable;
    @Column(name = "EQ_DATE_BOUTH")
    @Temporal(TemporalType.DATE)
    private Date eqDateBouth;
    @Column(name = "EQ_STATUS", length = 70)
    private String eqStatus;
    @JoinColumn(name = "EQ_VENDOR_ID", referencedColumnName = "EQ_VENDOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EquipmentVendors eqVendorId;
    @OneToMany(mappedBy = "equipmentId", fetch = FetchType.LAZY)
    private Collection<Stages> stagesCollection;

    public Equipment() {
    }

    public Equipment(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEqType() {
        return eqType;
    }

    public void setEqType(String eqType) {
        this.eqType = eqType;
    }

    public Integer getEqVlanAvailable() {
        return eqVlanAvailable;
    }

    public void setEqVlanAvailable(Integer eqVlanAvailable) {
        this.eqVlanAvailable = eqVlanAvailable;
    }

    public Date getEqDateBouth() {
        return eqDateBouth;
    }

    public void setEqDateBouth(Date eqDateBouth) {
        this.eqDateBouth = eqDateBouth;
    }

    public String getEqStatus() {
        return eqStatus;
    }

    public void setEqStatus(String eqStatus) {
        this.eqStatus = eqStatus;
    }

    public EquipmentVendors getEqVendorId() {
        return eqVendorId;
    }

    public void setEqVendorId(EquipmentVendors eqVendorId) {
        this.eqVendorId = eqVendorId;
    }

    @XmlTransient
    public Collection<Stages> getStagesCollection() {
        return stagesCollection;
    }

    public void setStagesCollection(Collection<Stages> stagesCollection) {
        this.stagesCollection = stagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentId != null ? equipmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.equipmentId == null && other.equipmentId != null) || (this.equipmentId != null && !this.equipmentId.equals(other.equipmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.Equipment[ equipmentId=" + equipmentId + " ]";
    }
    
}
