/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ST_STAGE_CONTACTS", catalog = "ST_OWNER_DEV", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StageContacts.findAll", query = "SELECT s FROM StageContacts s"),
    @NamedQuery(name = "StageContacts.findByStageContactId", query = "SELECT s FROM StageContacts s WHERE s.stageContactId = :stageContactId"),
    @NamedQuery(name = "StageContacts.findByStageContactAdress", query = "SELECT s FROM StageContacts s WHERE s.stageContactAdress = :stageContactAdress"),
    @NamedQuery(name = "StageContacts.findByStageContactPerson", query = "SELECT s FROM StageContacts s WHERE s.stageContactPerson = :stageContactPerson"),
    @NamedQuery(name = "StageContacts.findByStageContactPersonPhone", query = "SELECT s FROM StageContacts s WHERE s.stageContactPersonPhone = :stageContactPersonPhone"),
    @NamedQuery(name = "StageContacts.findByStageContactPhoneTech", query = "SELECT s FROM StageContacts s WHERE s.stageContactPhoneTech = :stageContactPhoneTech"),
    @NamedQuery(name = "StageContacts.findByStageContactSecurityPhone", query = "SELECT s FROM StageContacts s WHERE s.stageContactSecurityPhone = :stageContactSecurityPhone")})
public class StageContacts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STAGE_CONTACT_ID", nullable = false)
    private Integer stageContactId;
    @Column(name = "STAGE_CONTACT_ADRESS", length = 100)
    private String stageContactAdress;
    @Column(name = "STAGE_CONTACT_PERSON", length = 100)
    private String stageContactPerson;
    @Column(name = "STAGE_CONTACT_PERSON_PHONE")
    private Integer stageContactPersonPhone;
    @Column(name = "STAGE_CONTACT_PHONE_TECH")
    private Integer stageContactPhoneTech;
    @Column(name = "STAGE_CONTACT_SECURITY_PHONE")
    private Integer stageContactSecurityPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageContactId", fetch = FetchType.LAZY)
    private Collection<Stages> stagesCollection;

    public StageContacts() {
    }

    public StageContacts(Integer stageContactId) {
        this.stageContactId = stageContactId;
    }

    public Integer getStageContactId() {
        return stageContactId;
    }

    public void setStageContactId(Integer stageContactId) {
        this.stageContactId = stageContactId;
    }

    public String getStageContactAdress() {
        return stageContactAdress;
    }

    public void setStageContactAdress(String stageContactAdress) {
        this.stageContactAdress = stageContactAdress;
    }

    public String getStageContactPerson() {
        return stageContactPerson;
    }

    public void setStageContactPerson(String stageContactPerson) {
        this.stageContactPerson = stageContactPerson;
    }

    public Integer getStageContactPersonPhone() {
        return stageContactPersonPhone;
    }

    public void setStageContactPersonPhone(Integer stageContactPersonPhone) {
        this.stageContactPersonPhone = stageContactPersonPhone;
    }

    public Integer getStageContactPhoneTech() {
        return stageContactPhoneTech;
    }

    public void setStageContactPhoneTech(Integer stageContactPhoneTech) {
        this.stageContactPhoneTech = stageContactPhoneTech;
    }

    public Integer getStageContactSecurityPhone() {
        return stageContactSecurityPhone;
    }

    public void setStageContactSecurityPhone(Integer stageContactSecurityPhone) {
        this.stageContactSecurityPhone = stageContactSecurityPhone;
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
        hash += (stageContactId != null ? stageContactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StageContacts)) {
            return false;
        }
        StageContacts other = (StageContacts) object;
        if ((this.stageContactId == null && other.stageContactId != null) || (this.stageContactId != null && !this.stageContactId.equals(other.stageContactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.silvermanager.entities.StageContacts[ stageContactId=" + stageContactId + " ]";
    }
    
}
