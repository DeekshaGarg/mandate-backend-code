package com.airtelpaymentbank.enach.emandate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class GrpHdr {
	@Id
	@XmlElement
	private String NPCI_RefMsgId;
	
	@XmlElement
	private Date CreDtTm;
	
	@OneToOne(cascade=CascadeType.ALL )
	@XmlElement
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
