package com.airtelpaymentbank.enach.npcimockserver.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NpciMockServerControllerTest {

	@Test
	void testGetMndtAuthReq() {
		fail("Not yet implemented");
	}

	@Test
	/*void testGetRespPayObject() {
		String npciErrorCode=null;
		RespChkTxn respChkTxn=new RespChkTxn();
		respChkTxn.setResp(new RespChkTxn.Resp);
		
		
		RespChkTxn.Resp respPayResponse=respChkTxn.getResp();
		
		respChkTxn.getResp().setRef(new ArrayList<Ref>());
		respChkTxn.getResp().setErrCode("errorCode");
		
		Ref ref1=new Ref();
		ref1.setType(PayConstant.DEBIT);
		
		Ref ref2=new Ref();
		ref2.setRespCode(Constants.DEFAULT_NPCI_RESP_SUCCESS);
		respChkTxn.getResp().getRef().add(ref1);
		
		when(upiUtil.getCbsNpciErrorCode(any(),any(),any())).thenReturen("ErrorCode");
		
		npciChkTxnResponseService.getRespPayObject(respChkTxn);
		
		
	}*/
}
