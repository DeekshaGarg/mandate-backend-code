package com.airtelpaymentbank.enach.emandate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtelpaymentbank.enach.emandate.model.MandateStatus;

@Repository
public interface EMandateStatusRepository extends CrudRepository<MandateStatus, String>{
}
