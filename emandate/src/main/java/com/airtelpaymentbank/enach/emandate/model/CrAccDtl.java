package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CrAccDtl {
	private String Nm;
	private String AccNo;
	private String MmbId;

	@JsonIgnore
	@Id
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
