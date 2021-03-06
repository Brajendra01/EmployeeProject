package com.employee.empdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.empdemo.dao.EmpDao;
import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.enity.Vehicle;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpDao empDao;

	@Override
	public Employee getEmpDetails() {
		return empDao.getEmpDetails();
	}
	
	@Override
	public void saveVehicleInheritance(Vehicle vehicle){
		empDao.saveVehicleInheritance(vehicle);
	}
	
	@Override
	public List<Employee> getEmpList(){
		Employee employee1=new Employee();
		employee1.setId(100);
		employee1.setName("Harry");
		employee1.setSal(5000);
		
		Employee employee2=new Employee();
		employee2.setId(300);
		employee2.setName("Pankaj");
		employee2.setSal(2000);
		
		Employee employee3=new Employee();
		employee3.setId(200);
		employee3.setName("Ajay");
		employee3.setSal(4000);
		
		List<Employee> empList=new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		
		return empList;
	}
	
	
	@Override
	public Employee getEmpById(String id){
		Employee employee1=new Employee();
		employee1.setId(100);
		employee1.setName("Harry");
		employee1.setSal(5000);
		
		Employee employee2=new Employee();
		employee2.setId(300);
		employee2.setName("Pankaj");
		employee2.setSal(2000);
		
		Employee employee3=new Employee();
		employee3.setId(200);
		employee3.setName("Ajay");
		employee3.setSal(4000);
		
		List<Employee> empList=new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		
		Employee emp=(Employee) empList.parallelStream().filter(o->o.getId().toString().equals(id)).collect(Collectors.toList()).get(0);
		
		return emp;
		
	}

	@Override
	public void createEmp(Employee employee) {
		empDao.saveEmp(employee);
	}
	
	

}
