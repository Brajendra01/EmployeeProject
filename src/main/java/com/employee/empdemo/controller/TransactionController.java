package com.employee.empdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.service.EmpService;
import com.employee.empdemo.service.InnerTransactionBeanSevice;

@Controller
public class TransactionController {

	@Autowired
	EmpService empService;
	
	@Autowired
	InnerTransactionBeanSevice innerBean;
	
	/** Propagation=REQUIRED
	 * outer and inner both propagation type is "REQUIRED", 
	 * in that case if inner method throw an error or exception as runtime exception so that 
	 * outer execution will be rollback, see the example, inner method throw runtime exception so that outer bean method
	 * excution has been rollback and not saving data in database.
	 * 
	 * @Transactional(propagation=Propagation.REQUIRES_NEW)
	   public void innerTestRequired(){
		  throw new RuntimeException("innerTestRequired():::Rollback this transaction!!! ");
	   }
	 * 
	 * 
	 */
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	@RequestMapping(value="/transactionRequiredTest")
	public void insertEmpTransactionRequired(){
		Employee employee=new Employee();
		employee.setName("Transaction1");
		employee.setSal(4000);
		
		empService.createEmp(employee);
		
		try{
			innerBean.innerTestRequired();
		}catch(RuntimeException e){
			System.out.println("000000");
			e.printStackTrace();
		}
		System.out.println("11111111111");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@RequestMapping(value="/transactionRequiredTest")
	public void insertEmpRequiresNew(){
		Employee employee=new Employee();
		employee.setName("Transaction1");
		employee.setSal(4000);
		
		empService.createEmp(employee);
		
		try{
			innerBean.innerTestRequiresNew();
		}catch(RuntimeException e){
			System.out.println("000000");
			e.printStackTrace();
		}
		System.out.println("11111111111");
	}
}
