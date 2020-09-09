package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Mndt {
	@Id
	@XmlElement
	private String MndtReqId;
	@XmlElement
    private String MndtId;
	@XmlElement
    private String Mndt_Type;
	@XmlElement
    private String Schm_Nm;
    
    @OneToOne(cascade=CascadeType.ALL )
    @XmlElement(name = "Ocrncs")
    private Ocrncs ocrncs;
    
    @OneToOne(cascade=CascadeType.ALL )
    @XmlElement(name="ColltnAmt")
    private ColltnAmt colltnAmt;
    
    @OneToOne(cascade=CascadeType.ALL )
    @XmlElement(name="MaxAmt")
    private MaxAmt maxAmt;
    
    @OneToOne(cascade=CascadeType.ALL )
    @XmlElement(name="Dbtr")
    private Dbtr dbtr;
    
    @OneToOne(cascade=CascadeType.ALL )
    @XmlElement(name="CrAccDtl")
    private CrAccDtl crAccDtl;
	public String getMndtReqId() {
		return MndtReqId;
	}
	public void setMndtReqId(String mndtReqId) {
		MndtReqId = mndtReqId;
	}
	public String getMndtId() {
		return MndtId;
	}
	public void setMndtId(String mndtId) {
		MndtId = mndtId;
	}
	public String getMndt_Type() {
		return Mndt_Type;
	}
	public void setMndt_Type(String mndt_Type) {
		Mndt_Type = mndt_Type;
	}
	public String getSchm_Nm() {
		return Schm_Nm;
	}
	public void setSchm_Nm(String schm_Nm) {
		Schm_Nm = schm_Nm;
	}
	public Ocrncs getOcrncs() {
		return ocrncs;
	}
	public void setOcrncs(Ocrncs ocrncs) {
		this.ocrncs = ocrncs;
	}
	public ColltnAmt getColltnAmt() {
		return colltnAmt;
	}
	public void setColltnAmt(ColltnAmt colltnAmt) {
		this.colltnAmt = colltnAmt;
	}
	public MaxAmt getMaxAmt() {
		return maxAmt;
	}
	public void setMaxAmt(MaxAmt maxAmt) {
		this.maxAmt = maxAmt;
	}
	public Dbtr getDbtr() {
		return dbtr;
	}
	public void setDbtr(Dbtr dbtr) {
		this.dbtr = dbtr;
	}
	public CrAccDtl getCrAccDtl() {
		return crAccDtl;
	}
	public void setCrAccDtl(CrAccDtl crAccDtl) {
		this.crAccDtl = crAccDtl;
	}
}
