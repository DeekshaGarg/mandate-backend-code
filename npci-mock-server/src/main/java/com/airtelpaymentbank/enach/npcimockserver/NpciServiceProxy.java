package com.airtelpaymentbank.enach.npcimockserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.airtelpaymentbank.enach.npcimockserver.model.MandateDetails;
import com.airtelpaymentbank.enach.npcimockserver.model.MndtAuthReq;

@FeignClient(name = "emandate")
public interface NpciServiceProxy {

	@PostMapping("/bank/mandate/auth-request/{authMode}")
	public MandateDetails mndtAuthReqToBank(@RequestBody MndtAuthReq mndtAuthReq, @PathVariable("authMode") String authMode);

}
