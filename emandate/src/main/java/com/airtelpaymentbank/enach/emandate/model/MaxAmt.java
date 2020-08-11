package com.airtelpaymentbank.enach.emandate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MaxAmt {

	private String _Ccy;
	private BigDecimal __text;
	@JsonIgnore
	@Id
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
