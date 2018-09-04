package com.employee.empdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.service.EmpServiceImpl;

@RestController
public class EmpController {
	
	@Autowired
	EmpServiceImpl empService;
	
	@RequestMapping(value="/getEmpDetails",method=RequestMethod.GET)
	public Employee getEmpDetails(){
		System.out.println("getEmpDetails()::");
		return empService.getEmpDetails();
	}
	
	@RequestMapping(value="/getEmpList", method=RequestMethod.GET)
	public List<Employee> getEmpList(){
		System.out.println("getEmpList()::");
		return empService.getEmpList();
	}
	
	@RequestMapping(value="/getEmpById/{id}",method=RequestMethod.GET)
	public Employee getEmpById(@PathVariable String id){
		return empService.getEmpById(id);
	}
	
	@RequestMapping(value="/createEmp", method=RequestMethod.POST)
	public void createEmp(@RequestBody Employee employee){
		empService.createEmp(employee);
	}

}
