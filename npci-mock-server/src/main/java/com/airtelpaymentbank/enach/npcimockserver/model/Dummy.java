package com.airtelpaymentbank.enach.npcimockserver.model;

import org.springframework.web.multipart.MultipartFile;

public class Dummy {

	private String MerchantID;
	private  String SPID;
	private MultipartFile MandateReqDoc;
	
	private String CheckSumVal;
	private  String BankID;
	private String AuthMode;
	public String getMerchantID() {
		return MerchantID;
	}
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	public String getSPID() {
		return SPID;
	}
	public void setSPID(String sPID) {
		SPID = sPID;
	}
	public MultipartFile getMandateReqDoc() {
		return MandateReqDoc;
	}
	public void setMandateReqDoc(MultipartFile  mandateReqDoc) {
		MandateReqDoc = mandateReqDoc;
	}
	public String getCheckSumVal() {
		return CheckSumVal;
	}
	public void setCheckSumVal(String checkSumVal) {
		CheckSumVal = checkSumVal;
	}
	public String getBankID() {
		return BankID;
	}
	public void setBankID(String bankID) {
		BankID = bankID;
	}
	public String getAuthMode() {
		return AuthMode;
	}
	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}
	
}
