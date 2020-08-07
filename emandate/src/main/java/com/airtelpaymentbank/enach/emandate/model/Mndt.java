package com.airtelpaymentbank.enach.emandate.model;

public class Mndt {
	private String MndtReqId;
    private String MndtId;
    private String Mndt_Type;
    private String Schm_Nm;
    private Ocrncs ocrncs;
    private ColltnAmt colltnAmt;
    private MaxAmt maxAmt;
    private Dbtr dbtr;
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
