package com.test.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.demo.model.EmpModel;
import com.test.demo.service.EmpService;

@Controller
public class EmpController {

	   @Autowired
	   private EmpService service;
	 
	   @RequestMapping(value = "/home")
	    public String showWelcomePage() { 
	        return "welcome";
	    }
	   
	   @RequestMapping(value = "/register")
	    public String showRegPage(Model model) {
		   EmpModel emp = new EmpModel();  
		   model.addAttribute("emp", emp);
	        return "registerPage";
	        }
	   
	   @RequestMapping(value = "/save-Details", method = RequestMethod.POST)
	   public String saveProduct(@ModelAttribute("emp") EmpModel emp)
	   {   
		   service.saveEmp(emp);    
		   
		   return "viewDetails";
	   }
	   
	   @RequestMapping(value = "/view",method = RequestMethod.GET)
	   public String viewPage(Model model)
	   {   
	 
		   List<EmpModel> empDetails = service.getAll(); 
		   
	       model.addAttribute("empDetails", empDetails); 
	      // System.out.println(empDetails);
	       return "viewDetails";
	    
	   }
	   
	   @RequestMapping("/delete/{id}")
	   public String deleteEmployee(@PathVariable(name = "id") int id) {
	       service.delete(id);
	       return "redirect:/view";       
	   }
	   
	   @RequestMapping("/getEmp/{id}")
	   public String getEmployee(@PathVariable(name = "id") int id) {
		    service.get(id);
	       return "redirect:/view";       
	   }
	   
	  /* @GetMapping("/empDetails/{id}")
	   public ResponseEntity<EmpModel> get(@PathVariable Integer id) {
	       try {
	    	   EmpModel emp = service.get(id);
	           return new ResponseEntity<EmpModel>(emp, HttpStatus.OK);
	       } catch (NoSuchElementException e) {
	           return new ResponseEntity<EmpModel>(HttpStatus.NOT_FOUND);
	       }      
	   }*/
}
