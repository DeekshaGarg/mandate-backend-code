package com.airtelpaymentbank.enach.npcimockserver.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtelpaymentbank.enach.npcimockserver.model.ColltnAmt;
import com.airtelpaymentbank.enach.npcimockserver.model.CrAccDtl;
import com.airtelpaymentbank.enach.npcimockserver.model.Dbtr;
import com.airtelpaymentbank.enach.npcimockserver.model.GrpHdr;
import com.airtelpaymentbank.enach.npcimockserver.model.Info;
import com.airtelpaymentbank.enach.npcimockserver.model.MaxAmt;
import com.airtelpaymentbank.enach.npcimockserver.model.Mndt;
import com.airtelpaymentbank.enach.npcimockserver.model.MndtAuthReq;
import com.airtelpaymentbank.enach.npcimockserver.model.Ocrncs;
import com.airtelpaymentbank.enach.npcimockserver.model.ReqInitPty;

@RestController
public class NpciMockServerController {
	
	@GetMapping("/npci/mandate-auth-request")
	public MndtAuthReq getMndtAuthReq() {
		MndtAuthReq mndtAuthReq=new MndtAuthReq();
		GrpHdr grpHdr=new GrpHdr();
		grpHdr.setCreDtTm(new Date());
		grpHdr.setNPCI_RefMsgId("000f0f29dc27f00000101b09c5227457f17");
		ReqInitPty reqInitPty=new ReqInitPty();
		
		Info info=new Info();
		info.setCatCode("COO1");
		info.setCatDesc("Insurance Company");
		info.setId("HDFC00001123456789");
		info.setName("LIC");
		info.setSpn_Bnk_Nm("State Bank Of India");
		info.setUtilCode(6543);
		
		reqInitPty.setInfo(info);
		grpHdr.setReqInitPty(reqInitPty);
		
		mndtAuthReq.setGrpHdr(grpHdr);
		
		Mndt Mndt=new Mndt();
		ColltnAmt colltnAmt=new ColltnAmt();
		colltnAmt.set__text(new BigDecimal(1200));
		colltnAmt.set_Ccy("INR");
		Mndt.setColltnAmt(colltnAmt);
		
		CrAccDtl crAccDtl=new CrAccDtl();
		crAccDtl.setAccNo("ACNo78912340");
		crAccDtl.setMmbId("HDFC0000001");
		crAccDtl.setNm("ABC India Limited");
		Mndt.setCrAccDtl(crAccDtl);
		
		Dbtr dbtr=new Dbtr();
		dbtr.setAccNo("ACNo123456");
		dbtr.setAcct_Type("SAVINGS");
		dbtr.setCons_Ref_No("XXX123");
		dbtr.setEmail("XX@XX.COM");
		dbtr.setMobile("+91-XXXXXXXXXX");
		dbtr.setNm("FAIROSE");
		dbtr.setPan("XXXXX9999X");
		dbtr.setPhone("+91-XXX-XXXXXXXX");
		Mndt.setDbtr(dbtr);
		
		MaxAmt maxAmt=new MaxAmt();
		maxAmt.set__text(new BigDecimal(1200));
		maxAmt.set_Ccy("INR");
		Mndt.setMaxAmt(maxAmt);
		
		Mndt.setMndt_Type("DEBIT");
		Mndt.setMndtId("UMRN");
		Mndt.setMndtReqId("000f0f29dc27f00000101b09c52b8e50037");
		Mndt.setSchm_Nm("ABC123");
		Ocrncs ocrncs=new Ocrncs();
		ocrncs.setFnlColltnDt(new Date());
		ocrncs.setFrqcy("MNTH");
		ocrncs.setFrstColltnDt(new Date());
		ocrncs.setSeqTp("RCUR");
		Mndt.setOcrncs(ocrncs);
		mndtAuthReq.setMndt(Mndt);
		
		return mndtAuthReq;
	}

}
