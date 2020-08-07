package com.airtelpaymentbank.enach.npcimockserver.model;

import java.util.Date;

public class GrpHdr {
	private String NPCI_RefMsgId;
	private Date CreDtTm;
	private ReqInitPty ReqInitPty;
	public String getNPCI_RefMsgId() {
		return NPCI_RefMsgId;
	}
	public void setNPCI_RefMsgId(String NPCI_RefMsgId) {
		this.NPCI_RefMsgId = NPCI_RefMsgId;
	}
	public Date getCreDtTm() {
		return CreDtTm;
	}
	public void setCreDtTm(Date CreDtTm) {
		this.CreDtTm = CreDtTm;
	}
	public ReqInitPty getReqInitPty() {
		return ReqInitPty;
	}
	public void setReqInitPty(ReqInitPty ReqInitPty) {
		this.ReqInitPty = ReqInitPty;
	}
}
