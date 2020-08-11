package com.airtelpaymentbank.enach.emandate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Info {
	
	@JsonIgnore
	@Id
	private long idForDb;
	public long getIdForDb() {
		return idForDb;
	}
	public void setIdForDb(long idForDb) {
		this.idForDb = idForDb;
	}
	private String Id;
	private String CatCode;
	private int UtilCode;
	private String CatDesc;
	private String Name;
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
