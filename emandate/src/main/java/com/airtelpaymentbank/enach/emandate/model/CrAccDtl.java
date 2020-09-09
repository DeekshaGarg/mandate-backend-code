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
public class CrAccDtl {
	@XmlElement
	private String Nm;
	@XmlElement
	private String AccNo;
	@XmlElement
	private String MmbId;

	@JsonIgnore
	@Id
	@XmlTransient
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNm() {
		return Nm;
	}

	public void setNm(String nm) {
		Nm = nm;
	}

	public String getAccNo() {
		return AccNo;
	}

	public void setAccNo(String accNo) {
		AccNo = accNo;
	}

	public String getMmbId() {
		return MmbId;
	}

	public void setMmbId(String mmbId) {
		MmbId = mmbId;
	}
}
