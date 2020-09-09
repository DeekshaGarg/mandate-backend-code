package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class ReqInitPty {
	
	@OneToOne(cascade=CascadeType.ALL )
	@XmlElement
	private Info Info;
	@JsonIgnore
	@Id
	@XmlTransient
	private long idForDb;
	public long getIdForDb() {
		return idForDb;
	}
	public void setIdForDb(long idForDb) {
		this.idForDb = idForDb;
	}

	public Info getInfo() {
		return Info;
	}

	public void setInfo(Info info) {
		Info = info;
	}
}
