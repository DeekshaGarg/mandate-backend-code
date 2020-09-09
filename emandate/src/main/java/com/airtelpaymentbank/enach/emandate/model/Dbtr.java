package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Dbtr {
	@XmlElement
	private String Nm;
	@XmlElement
	private String AccNo;
	@XmlElement
    private String Acct_Type;
	@XmlElement
    private String Cons_Ref_No;
	@XmlElement
    private String Phone;
	@XmlElement
    private String Mobile;
	@XmlElement
    private String Email;
	@XmlElement
    private String Pan;
    
    @JsonIgnore
	@Id
	@XmlTransient
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNm() {
		return Nm;
	}
	public void setNm(String nm) {
		Nm = nm;
	}
	public String getAccNo() {
		return AccNo;
	}
	public void setAccNo(String accNo) {
		AccNo = accNo;
	}
	public String getAcct_Type() {
		return Acct_Type;
	}
	public void setAcct_Type(String acct_Type) {
		Acct_Type = acct_Type;
	}
	public String getCons_Ref_No() {
		return Cons_Ref_No;
	}
	public void setCons_Ref_No(String cons_Ref_No) {
		Cons_Ref_No = cons_Ref_No;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPan() {
		return Pan;
	}
	public void setPan(String pan) {
		Pan = pan;
	}
}
