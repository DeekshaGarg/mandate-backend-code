package com.test.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.model.EmpModel;

@Repository
public interface EmpRepository extends JpaRepository<EmpModel, Integer> {

}
