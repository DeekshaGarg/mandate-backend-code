package com.airtelpaymentbank.enach.emandate.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtelpaymentbank.enach.emandate.EmandateServiceProxy;
import com.airtelpaymentbank.enach.emandate.model.MandateDetails;
import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;
import com.airtelpaymentbank.enach.emandate.util.Utils;

@RestController
public class EMandateController {

	private Logger logger = LoggerFactory.getLogger(EMandateController.class);

	@Autowired
	private EmandateServiceProxy emandateServiceProxy;

	@GetMapping("/mandate-details")
	public MandateDetails getMandateDetails() {

		MndtAuthReq mandateInfo = emandateServiceProxy.getMndtAuthReq();

		logger.info("{=============================}", mandateInfo);

		String accountNo = mandateInfo.getMndt().getDbtr().getAccNo();
		String mandateIssuedTo = mandateInfo.getGrpHdr().getReqInitPty().getInfo().getName();
		String frequency = mandateInfo.getMndt().getOcrncs().getFrqcy();
		BigDecimal amountInFigures = mandateInfo.getMndt().getColltnAmt().get__text();
		Date startDate = mandateInfo.getMndt().getOcrncs().getFrstColltnDt();
		Date endDate = mandateInfo.getMndt().getOcrncs().getFnlColltnDt();
		String amountInWords = Utils.getMoneyIntoWord(amountInFigures);

		return new MandateDetails(accountNo, mandateIssuedTo, frequency, amountInFigures, amountInWords,
				Utils.dateConverter(startDate), Utils.dateConverter(endDate), "Purpose of mandate");
	}

}
