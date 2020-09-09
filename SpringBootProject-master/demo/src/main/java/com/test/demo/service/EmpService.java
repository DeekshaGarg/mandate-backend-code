package com.test.demo.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.test.demo.model.EmpModel;
import com.test.demo.repository.EmpRepository;



@Service
@Transactional
public class EmpService {
	
	  @Autowired
	  private EmpRepository repo;
	  
      public List<EmpModel> getAll() 
      {    
    	  return repo.findAll();  
      
      }
      
	   public void saveEmp(EmpModel  emp) {
	        repo.save(emp);
	    }
	     
	    public EmpModel  get(Integer id) {
	        return repo.findById(id).get();
	    }
	    
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
}
