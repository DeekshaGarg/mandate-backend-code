package com.airtelpaymentbank.enach.emandate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ColltnAmt {
	
	@JsonIgnore
	@Id
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String _Ccy;
    private BigDecimal __text;
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



