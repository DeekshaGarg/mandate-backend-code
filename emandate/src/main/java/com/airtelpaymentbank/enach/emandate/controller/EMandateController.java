package com.airtelpaymentbank.enach.emandate.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airtelpaymentbank.enach.emandate.model.MandateDetails;
import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;
import com.airtelpaymentbank.enach.emandate.repository.EmandateRepository;
import com.airtelpaymentbank.enach.emandate.util.Utils;

@RestController
public class EMandateController {

	private Logger logger = LoggerFactory.getLogger(EMandateController.class);
	
	@Autowired
	private EmandateRepository emandateRepository;
	
	@GetMapping("/")
	public String welcomePageAfterOAuth() {
		return "Welcome to Emandate application";
	}

	
	@PostMapping("/bank/mandate-auth-request/{authMode}")
	public MandateDetails mndtAuthReqToBank(@RequestBody MndtAuthReq mndtAuthReq, @PathVariable String authMode) {
		
		logger.info("======================Data saving to db: start==================");
		
		emandateRepository.save(mndtAuthReq);
		
		logger.info("=================Data Saved to Db : end=======================");
		
		String accountNo = mndtAuthReq.getMndt().getDbtr().getAccNo();
		String mandateIssuedTo = mndtAuthReq.getGrpHdr().getReqInitPty().getInfo().getName();
		String frequency = mndtAuthReq.getMndt().getOcrncs().getFrqcy();
		BigDecimal amountInFigures = mndtAuthReq.getMndt().getColltnAmt().get__text();
		Date startDate = mndtAuthReq.getMndt().getOcrncs().getFrstColltnDt();
		Date endDate = mndtAuthReq.getMndt().getOcrncs().getFnlColltnDt();
		String amountInWords = Utils.getMoneyIntoWord(amountInFigures);
		
		return new MandateDetails(accountNo, mandateIssuedTo, frequency, amountInFigures, amountInWords,
				Utils.dateConverter(startDate), Utils.dateConverter(endDate), "Purpose of mandate",authMode);
	
	}

}
