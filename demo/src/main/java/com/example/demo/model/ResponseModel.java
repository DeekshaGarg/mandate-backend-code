package com.example.demo.model;

import java.util.Date;

public class ResponseModel {

	private Date date;
	private String message;
	private String status;
	public ResponseModel(Date date, String message, String status) {
		super();
		this.date = date;
		this.message = message;
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}


}
