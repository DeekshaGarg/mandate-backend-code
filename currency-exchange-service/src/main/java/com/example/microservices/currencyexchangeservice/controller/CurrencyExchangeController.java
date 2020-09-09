package com.example.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.ExchangeValueRepository;
import com.example.microservices.currencyexchangeservice.bean.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue= new ExchangeValue(100, "IND", "US", BigDecimal.valueOf(200));
		exchangeValue.setPort(Integer.valueOf(env.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	@GetMapping("/jpa/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValueFromJPA(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue=exchangeValueRepository.findByFromAndTo(from,to);
		
		exchangeValue.setPort(Integer.valueOf(env.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	@PostMapping("/exchange-value")
	public ExchangeValue createExchangeValue(@RequestBody ExchangeValue exchangeValue) {
		return exchangeValueRepository.save(exchangeValue);
	}

}
