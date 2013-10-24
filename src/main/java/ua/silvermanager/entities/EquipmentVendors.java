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
@Table(name = "ST_EQUIPMENT_VENDORS", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipmentVendors.findAll", query = "SELECT e FROM EquipmentVendors e"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorId", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorId = :eqVendorId"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorName", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorName = :eqVendorName"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorModel", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorModel = :eqVendorModel"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorSerialNum", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorSerialNum = :eqVendorSerialNum"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorSoftware", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorSoftware = :eqVendorSoftware"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorPortsCount", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorPortsCount = :eqVendorPortsCount"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorOpticalCount", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorOpticalCount = :eqVendorOpticalCount"),
    @NamedQuery(name = "EquipmentVendors.findByEqVendorYear", query = "SELECT e FROM EquipmentVendors e WHERE e.eqVendorYear = :eqVendorYear")})
public class EquipmentVendors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EQ_VENDOR_ID", nullable = false)
    private Integer eqVendorId;
    @Column(name = "EQ_VENDOR_NAME", length = 70)
    private String eqVendorName;
    @Column(name = "EQ_VENDOR_MODEL", length = 70)
    private String eqVendorModel;
    @Column(name = "EQ_VENDOR_SERIAL_NUM")
    private Integer eqVendorSerialNum;
    @Column(name = "EQ_VENDOR_SOFTWARE", length = 100)
    private String eqVendorSoftware;
    @Column(name = "EQ_VENDOR_PORTS_COUNT")
    private Integer eqVendorPortsCount;
    @Column(name = "EQ_VENDOR_OPTICAL_COUNT")
    private Integer eqVendorOpticalCount;
    @Column(name = "EQ_VENDOR_YEAR")
    private Integer eqVendorYear;
    @OneToMany(mappedBy = "eqVendorId", fetch = FetchType.LAZY)
    private Collection<Equipment> equipmentCollection;

    public EquipmentVendors() {
    }

    public EquipmentVendors(Integer eqVendorId) {
        this.eqVendorId = eqVendorId;
    }

    public Integer getEqVendorId() {
        return eqVendorId;
    }

    public void setEqVendorId(Integer eqVendorId) {
        this.eqVendorId = eqVendorId;
    }

    public String getEqVendorName() {
        return eqVendorName;
    }

    public void setEqVendorName(String eqVendorName) {
        this.eqVendorName = eqVendorName;
    }

    public String getEqVendorModel() {
        return eqVendorModel;
    }

    public void setEqVendorModel(String eqVendorModel) {
        this.eqVendorModel = eqVendorModel;
    }

    public Integer getEqVendorSerialNum() {
        return eqVendorSerialNum;
    }

    public void setEqVendorSerialNum(Integer eqVendorSerialNum) {
        this.eqVendorSerialNum = eqVendorSerialNum;
    }

    public String getEqVendorSoftware() {
        return eqVendorSoftware;
    }

    public void setEqVendorSoftware(String eqVendorSoftware) {
        this.eqVendorSoftware = eqVendorSoftware;
    }

    public Integer getEqVendorPortsCount() {
        return eqVendorPortsCount;
    }

    public void setEqVendorPortsCount(Integer eqVendorPortsCount) {
        this.eqVendorPortsCount = eqVendorPortsCount;
    }

    public Integer getEqVendorOpticalCount() {
        return eqVendorOpticalCount;
    }

    public void setEqVendorOpticalCount(Integer eqVendorOpticalCount) {
        this.eqVendorOpticalCount = eqVendorOpticalCount;
    }

    public Integer getEqVendorYear() {
        return eqVendorYear;
    }

    public void setEqVendorYear(Integer eqVendorYear) {
        this.eqVendorYear = eqVendorYear;
    }

    @XmlTransient
    public Collection<Equipment> getEquipmentCollection() {
        return equipmentCollection;
    }

    public void setEquipmentCollection(Collection<Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqVendorId != null ? eqVendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipmentVendors)) {
            return false;
        }
        EquipmentVendors other = (EquipmentVendors) object;
        if ((this.eqVendorId == null && other.eqVendorId != null) || (this.eqVendorId != null && !this.eqVendorId.equals(other.eqVendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.EquipmentVendors[ eqVendorId=" + eqVendorId + " ]";
    }
    
}
