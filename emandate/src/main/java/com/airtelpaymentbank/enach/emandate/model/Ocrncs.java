package com.airtelpaymentbank.enach.emandate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ocrncs {
	private String SeqTp;
	private String Frqcy;
	private Date FrstColltnDt;
	private Date FnlColltnDt;
	@JsonIgnore
	@Id
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
	public Date getFrstColltnDt() {
		return FrstColltnDt;
	}
	public void setFrstColltnDt(Date frstColltnDt) {
		FrstColltnDt = frstColltnDt;
	}
	public Date getFnlColltnDt() {
		return FnlColltnDt;
	}
	public void setFnlColltnDt(Date fnlColltnDt) {
		FnlColltnDt = fnlColltnDt;
	}
}
