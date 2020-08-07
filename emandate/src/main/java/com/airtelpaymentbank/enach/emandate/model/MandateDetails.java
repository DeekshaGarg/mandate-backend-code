package com.airtelpaymentbank.enach.emandate.model;

import java.math.BigDecimal;
import java.util.Date;

public class MandateDetails {
	
	private String accountNumber;
	private String mandateIssuedTo;
	private String frequency;
	private BigDecimal amountInFigures;
	private String amountInWords;
	private String startDate;
	private String endDate;
	private String purposeOfMandate;
	
	public MandateDetails(String accountNumber, String mandateIssuedTo, String frequency, BigDecimal amountInFigures,
			String amountInWords, String startDate, String endDate, String purposeOfMandate) {
		super();
		this.accountNumber = accountNumber;
		this.mandateIssuedTo = mandateIssuedTo;
		this.frequency = frequency;
		this.amountInFigures = amountInFigures;
		this.amountInWords = amountInWords;
		this.startDate = startDate;
		this.endDate = endDate;
		this.purposeOfMandate = purposeOfMandate;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMandateIssuedTo() {
		return mandateIssuedTo;
	}
	public void setMandateIssuedTo(String mandateIssuedTo) {
		this.mandateIssuedTo = mandateIssuedTo;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public BigDecimal getAmountInFigures() {
		return amountInFigures;
	}
	public void setAmountInFigures(BigDecimal amountInFigures) {
		this.amountInFigures = amountInFigures;
	}
	public String getAmountInWords() {
		return amountInWords;
	}
	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPurposeOfMandate() {
		return purposeOfMandate;
	}
	public void setPurposeOfMandate(String purposeOfMandate) {
		this.purposeOfMandate = purposeOfMandate;
	}

}
