package com.employee.empdemo.service;

import java.util.List;

import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.enity.Vehicle;

public interface EmpService {
	
	public Employee getEmpDetails();
	
	public List<Employee> getEmpList();
	
	public Employee getEmpById(String id);
	
	public void createEmp(Employee employee);
	
	public void saveVehicleInheritance(Vehicle vehicle);

}
