package com.test.demo.model;

import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "employees")
//@EntityListeners(AuditingEntityListener.class)
public class EmpModel {
	    
	    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    
	    private String empName;
	    
	    private String empDept;
	    
	    private String empAddress;
	  
	    private float salary;
	    
	  public EmpModel() {
		  super();
	  }
	public EmpModel(Integer id, String empName, String empDept, String empAddress, float salary) {
	super();
	this.id = id;
	this.empName = empName;
	this.empDept = empDept;
	this.empAddress = empAddress;
	this.salary = salary;
}

	 
	    public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmpDept() {
			return empDept;
		}

		public void setEmpDept(String empDept) {
			this.empDept = empDept;
		}

		public String getEmpAddress() {
			return empAddress;
		}

		public void setEmpAddress(String empAddress) {
			this.empAddress = empAddress;
		}

		public float getSalary() {
			return salary;
		}

		public void setSalary(float salary) {
			this.salary = salary;
		}


		@Override
		public String toString() {
			return "EmpModel [id=" + id + ", empName=" + empName + ", empDept=" + empDept + ", empAddress=" + empAddress
					+ ", salary=" + salary + "]";
		}

	

}
