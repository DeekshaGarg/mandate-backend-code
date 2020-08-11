package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReqInitPty {
	
	@OneToOne(cascade=CascadeType.ALL )
	private Info Info;
	@JsonIgnore
	@Id
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
