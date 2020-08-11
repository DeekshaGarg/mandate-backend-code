package com.airtelpaymentbank.enach.emandate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GrpHdr {
	@Id
	private String NPCI_RefMsgId;
	private Date CreDtTm;
	
	@OneToOne(cascade=CascadeType.ALL )
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
