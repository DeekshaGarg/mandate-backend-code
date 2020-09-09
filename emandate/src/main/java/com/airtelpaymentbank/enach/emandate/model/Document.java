package com.airtelpaymentbank.enach.emandate.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
	
	@XmlElement(name = "MndtAuthReq")
	private MndtAuthReq mndtAuthReq;

	public Document() {
		
	}
	public Document(MndtAuthReq mndtAuthReq) {
		super();
		this.mndtAuthReq = mndtAuthReq;
	}

	public MndtAuthReq getMndtAuthReq() {
		return mndtAuthReq;
	}

	public void setMndtAuthReq(MndtAuthReq mndtAuthReq) {
		this.mndtAuthReq = mndtAuthReq;
	}
}
