package com.airtelpaymentbank.enach.npcimockserver.model;

public class Mndt {
	private String MndtReqId;
    private String MndtId;
    private String Mndt_Type;
    private String Schm_Nm;
    private Ocrncs Ocrncs;
    private ColltnAmt ColltnAmt;
    private MaxAmt MaxAmt;
    private Dbtr Dbtr;
    private CrAccDtl CrAccDtl;
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
		return Ocrncs;
	}
	public void setOcrncs(Ocrncs ocrncs) {
		Ocrncs = ocrncs;
	}
	public ColltnAmt getColltnAmt() {
		return ColltnAmt;
	}
	public void setColltnAmt(ColltnAmt colltnAmt) {
		ColltnAmt = colltnAmt;
	}
	public MaxAmt getMaxAmt() {
		return MaxAmt;
	}
	public void setMaxAmt(MaxAmt maxAmt) {
		MaxAmt = maxAmt;
	}
	public Dbtr getDbtr() {
		return Dbtr;
	}
	public void setDbtr(Dbtr dbtr) {
		Dbtr = dbtr;
	}
	public CrAccDtl getCrAccDtl() {
		return CrAccDtl;
	}
	public void setCrAccDtl(CrAccDtl crAccDtl) {
		CrAccDtl = crAccDtl;
	}
	}
