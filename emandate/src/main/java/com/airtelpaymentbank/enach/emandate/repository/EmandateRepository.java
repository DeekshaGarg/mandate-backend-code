package com.airtelpaymentbank.enach.emandate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtelpaymentbank.enach.emandate.model.MndtAuthReq;

@Repository
public interface EMandateRepository extends CrudRepository<MndtAuthReq, Long>{

}
