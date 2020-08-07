package com.airtelpaymentbank.enach.emandate.model;

public class MndtAuthReq {
	public GrpHdr GrpHdr;
    public Mndt Mndt;
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
