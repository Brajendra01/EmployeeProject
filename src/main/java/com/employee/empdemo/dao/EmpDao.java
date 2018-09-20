package com.employee.empdemo.dao;

import java.util.List;

import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.enity.Vehicle;

public interface EmpDao {
	
	public void saveEmp(Employee employee);
	
	public Employee getEmpDetails();
	
	public void saveVehicleInheritance(Vehicle vehicle);
	

}
