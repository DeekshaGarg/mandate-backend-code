package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MndtAuthReq {
	
	@OneToOne(cascade=CascadeType.ALL )
	@XmlElement
	public GrpHdr GrpHdr;
	
	@OneToOne(cascade=CascadeType.ALL )
	@XmlElement
    public Mndt Mndt;
	
    @JsonIgnore
	@Id
	@XmlTransient
	private long idForDb;
    
    
	public long getIdForDb() {
		return idForDb;
	}
	public void setIdForDb(long idForDb) {
		this.idForDb = idForDb;
	}
	public GrpHdr getGrpHdr() {
		return GrpHdr;
	}
	public void setGrpHdr(GrpHdr GrpHdr) {
		this.GrpHdr = GrpHdr;
	}
	public Mndt getMndt() {
		return Mndt;
	}
	public void setMndt(Mndt Mndt) {
		this.Mndt = Mndt;
	}
}
