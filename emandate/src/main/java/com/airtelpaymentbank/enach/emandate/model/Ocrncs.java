package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Ocrncs {
	
	@XmlElement
	private String SeqTp;
	@XmlElement
	private String Frqcy;
	@XmlElement
	private String FrstColltnDt;
	@XmlElement
	private String FnlColltnDt;
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
	public String getSeqTp() {
		return SeqTp;
	}
	public void setSeqTp(String seqTp) {
		SeqTp = seqTp;
	}
	public String getFrqcy() {
		return Frqcy;
	}
	public void setFrqcy(String frqcy) {
		Frqcy = frqcy;
	}
	public String getFrstColltnDt() {
		return FrstColltnDt;
	}
	public void setFrstColltnDt(String frstColltnDt) {
		FrstColltnDt = frstColltnDt;
	}
	public String getFnlColltnDt() {
		return FnlColltnDt;
	}
	public void setFnlColltnDt(String fnlColltnDt) {
		FnlColltnDt = fnlColltnDt;
	}
}
