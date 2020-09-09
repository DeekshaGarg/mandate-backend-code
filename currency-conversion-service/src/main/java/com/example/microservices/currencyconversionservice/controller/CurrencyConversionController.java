package com.example.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.example.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	
	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);


	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVars = new HashMap<>();
		uriVars.put("from", from);
		uriVars.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/jpa/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVars);

		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());

	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = currencyExchangeServiceProxy.retriveExchangeValueUsingZuul(from, to);
		
		logger.info("{}",response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());

	}
}
