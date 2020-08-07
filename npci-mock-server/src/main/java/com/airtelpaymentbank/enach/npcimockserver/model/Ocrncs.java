package com.airtelpaymentbank.enach.npcimockserver.model;

import java.util.Date;

public class Ocrncs {
	private String SeqTp;
	private String Frqcy;
	private Date FrstColltnDt;
	private Date FnlColltnDt;
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
