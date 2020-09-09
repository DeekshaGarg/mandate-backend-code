package com.airtelpaymentbank.enach.emandate.service;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.airtelpaymentbank.enach.emandate.model.MandateDetails;
import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;
import com.airtelpaymentbank.enach.emandate.repository.EMandateRepository;
import com.airtelpaymentbank.enach.emandate.util.Utils;
import org.springframework.stereotype.Service;

@Service
public class EMandateService {

	@Autowired
	private EMandateRepository eMandateRepository;

	public MandateDetails getMandateDetails(MndtAuthReq mndtAuthReq, String authMode) {
		String mndtReqId = mndtAuthReq.getMndt().getMndtReqId();
		String accountNo = mndtAuthReq.getMndt().getDbtr().getAccNo();
		String mandateIssuedTo = mndtAuthReq.getGrpHdr().getReqInitPty().getInfo().getName();
		String frequency = mndtAuthReq.getMndt().getOcrncs().getFrqcy();
		BigDecimal amountInFigures = mndtAuthReq.getMndt().getColltnAmt().get__text();
		String startDate = mndtAuthReq.getMndt().getOcrncs().getFrstColltnDt();
		String endDate = mndtAuthReq.getMndt().getOcrncs().getFnlColltnDt();
		String amountInWords = Utils.getMoneyIntoWord(amountInFigures);

		return new MandateDetails(mndtReqId, accountNo, mandateIssuedTo, frequency, amountInFigures, amountInWords,
				startDate, endDate, "Purpose of mandate", authMode);
	}

	public void save(MndtAuthReq mndtAuthReq) {
		eMandateRepository.save(mndtAuthReq);
	}

}
