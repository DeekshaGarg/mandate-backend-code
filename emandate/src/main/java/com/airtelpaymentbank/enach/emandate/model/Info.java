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
public class Info {
	
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
	
	@XmlElement
	private String Id;
	@XmlElement
	private String CatCode;
	@XmlElement
	private int UtilCode;
	@XmlElement
	private String CatDesc;
	@XmlElement
	private String Name;
	@XmlElement
	private String Spn_Bnk_Nm;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCatCode() {
		return CatCode;
	}
	public void setCatCode(String catCode) {
		CatCode = catCode;
	}
	public int getUtilCode() {
		return UtilCode;
	}
	public void setUtilCode(int utilCode) {
		UtilCode = utilCode;
	}
	public String getCatDesc() {
		return CatDesc;
	}
	public void setCatDesc(String catDesc) {
		CatDesc = catDesc;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSpn_Bnk_Nm() {
		return Spn_Bnk_Nm;
	}
	public void setSpn_Bnk_Nm(String spn_Bnk_Nm) {
		Spn_Bnk_Nm = spn_Bnk_Nm;
	}
}
