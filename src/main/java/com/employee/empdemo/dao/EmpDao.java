package com.employee.empdemo.dao;

import java.util.List;

import com.employee.empdemo.enity.Employee;

public interface EmpDao {
	
	public void saveEmp(Employee employee);
	
	public Employee getEmpDetails();

}
