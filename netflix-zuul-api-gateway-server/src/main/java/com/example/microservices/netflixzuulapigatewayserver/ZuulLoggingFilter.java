package com.example.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	 
	private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);


	//if u want to execute filter or not
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//real logic of intersection
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request,request.getRequestURI());
		return null;
	}

	//when should it execute, before call, afer call etc
	@Override
	public String filterType() {
		return "pre";
	}
	
	//when we have multiple filters, we can set order

	@Override
	public int filterOrder() {
		return 1;
	}

}
