package com.airtelpaymentbank.enach.emandate.model;

import java.util.Date;

public class GrpHdr {
	private String NPCI_RefMsgId;
	private Date CreDtTm;
	private ReqInitPty ReqInitPty;
	public String getNPCI_RefMsgId() {
		return NPCI_RefMsgId;
	}
	public void setNPCI_RefMsgId(String nPCI_RefMsgId) {
		NPCI_RefMsgId = nPCI_RefMsgId;
	}
	public Date getCreDtTm() {
		return CreDtTm;
	}
	public void setCreDtTm(Date creDtTm) {
		CreDtTm = creDtTm;
	}
	public ReqInitPty getReqInitPty() {
		return ReqInitPty;
	}
	public void setReqInitPty(ReqInitPty reqInitPty) {
		ReqInitPty = reqInitPty;
	}
}
