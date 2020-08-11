package com.airtelpaymentbank.enach.emandate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MandateStatus {
	@Id
	private String mndtReqId;
	private String mandateStatus;
	private Date createdTimestamp;
	private String createdBy;
	public String getMndtReqId() {
		return mndtReqId;
	}
	public void setMndtReqId(String mndtReqId) {
		this.mndtReqId = mndtReqId;
	}
	public String getMandateStatus() {
		return mandateStatus;
	}
	public void setMandateStatus(String mandateStatus) {
		this.mandateStatus = mandateStatus;
	}
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
