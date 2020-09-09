package com.example.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.currencyexchangeservice.bean.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer>{

	ExchangeValue findByFromAndTo(String from, String to);
}
