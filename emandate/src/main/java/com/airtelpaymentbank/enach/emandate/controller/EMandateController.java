package com.airtelpaymentbank.enach.emandate.controller;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airtelpaymentbank.enach.emandate.model.MandateDetails;
import com.airtelpaymentbank.enach.emandate.model.MandateStatus;
import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;
import com.airtelpaymentbank.enach.emandate.service.EMandateService;
import com.airtelpaymentbank.enach.emandate.service.EMandateStatusService;

@RestController
public class EMandateController {

	private final Logger logger = LoggerFactory.getLogger(EMandateController.class);
	
	@Autowired
	private EMandateService eMandateService;
		
	@Autowired
	private EMandateStatusService eMandateStatusService;
	
	@PostMapping("/bank/mandate/auth-request/{authMode}")
	public MandateDetails mndtAuthReqToBank(@RequestBody MndtAuthReq mndtAuthReq, @PathVariable String authMode) {
		
		logger.info("======================mndtAuthReq saving to db: started==================");	
		eMandateService.save(mndtAuthReq);	
		logger.info("=================mndtAuthReq Saved to Db : end=======================");		
		return eMandateService.getMandateDetails(mndtAuthReq, authMode);
	
	}
	
	@PostMapping("/bank/mandate/status")
	public MandateStatus saveStatus(@RequestBody MandateStatus status) throws IOException {
		status.setCreatedBy("");
		status.setCreatedTimestamp(new Date());
		//eMandateStatusService.enableUpi("","");
		logger.info("======================MandateStatus saving to db: started==================");	
		eMandateStatusService.save(status);
		logger.info("======================MandateStatus saving to db: started==================");	
		return status;
	}

}
