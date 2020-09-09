package com.airtelpaymentbank.enach.emandate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtelpaymentbank.enach.emandate.model.MandateStatus;
import com.airtelpaymentbank.enach.emandate.repository.EMandateStatusRepository;

@Service
public class EMandateStatusService {
	
	@Autowired
	private EMandateStatusRepository eMandateStatusRepository;

	public void save(MandateStatus status) {
		eMandateStatusRepository.save(status);
	}

	/*
	 * public MandateStatus enableUpi(String mobile, String action) throws
	 * IOException{ String reqUrl="" + mobile +action; HttpHeaders headers=new
	 * HttpHeaders(); headers.add("channel","APP");
	 * 
	 * MandateStatus meta=new MandateStatus(); meta.setMndtReqId(reqUrl);
	 * if(null!=meta && Constants.IS_WEB_APP==false){ meta.setCreatedBy("hello");
	 * headers.add("", ""); }else if(null!=meta){ meta.setMandateStatus("approve");
	 * } return meta; }
	 */
}
