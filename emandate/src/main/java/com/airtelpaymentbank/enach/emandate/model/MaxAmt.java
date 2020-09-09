package com.airtelpaymentbank.enach.emandate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class MaxAmt {

	@XmlAttribute(name="Ccy")
	private String _Ccy;
	
	@XmlValue
	private BigDecimal __text;
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
	public String get_Ccy() {
		return _Ccy;
	}
	public void set_Ccy(String _Ccy) {
		this._Ccy = _Ccy;
	}
	public BigDecimal get__text() {
		return __text;
	}
	public void set__text(BigDecimal __text) {
		this.__text = __text;
	}
}
