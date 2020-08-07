package com.airtelpaymentbank.enach.emandate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;

@FeignClient(name = "npci-mock-server")
//@RibbonClient(name="npci-mock-server")
//@FeignClient(name = "netflix-zuul-api-gateway-server")
public interface EmandateServiceProxy {

	@GetMapping("/npci/mandate-auth-request")
	public MndtAuthReq getMndtAuthReq();

}
