package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MndtAuthReq {
	
	@OneToOne(cascade=CascadeType.ALL )
	public GrpHdr GrpHdr;
	
	@OneToOne(cascade=CascadeType.ALL )
    public Mndt Mndt;
    @JsonIgnore
	@Id
	private long idForDb;
	public long getIdForDb() {
		return idForDb;
	}
	public void setIdForDb(long idForDb) {
		this.idForDb = idForDb;
	}
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
