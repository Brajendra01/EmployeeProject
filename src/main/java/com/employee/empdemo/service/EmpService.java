package com.employee.empdemo.service;

import java.util.List;

import com.employee.empdemo.enity.Employee;

public interface EmpService {
	
	public Employee getEmpDetails();
	
	public List<Employee> getEmpList();
	
	public Employee getEmpById(String id);

}
