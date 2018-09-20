package com.employee.empdemo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.empdemo.enity.Address;
import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.enity.FourWheeler;
import com.employee.empdemo.enity.Phone;
import com.employee.empdemo.enity.TwoWheeler;
import com.employee.empdemo.enity.Vehicle;
import com.employee.empdemo.service.EmpServiceImpl;

@Controller
public class EmpController {
	
	@Autowired
	EmpServiceImpl empService;
	
	/*@RequestMapping(value="/getEmpDetails",method=RequestMethod.GET)
	public Employee getEmpDetails(){
		System.out.println("getEmpDetails()::");
		return empService.getEmpDetails();
	}*/
	
	@RequestMapping(value="/getEmpList", method=RequestMethod.GET)
	public ModelAndView getEmpList(){
		System.out.println("getEmpList()::");
		ModelAndView model=new ModelAndView();
		model.setViewName("empDetailsPage");
		model.addObject("empList",empService.getEmpList());
		return model;
		//return empService.getEmpList();
	}
	
	@RequestMapping(value="/getEmpById/{id}",method=RequestMethod.GET)
	public Employee getEmpById(@PathVariable String id){
		return empService.getEmpById(id);
	}
	
	@RequestMapping(value="/createEmp", method=RequestMethod.POST)
	public void createEmp(@RequestBody Employee employee){
		
		Employee emp=new Employee();
		emp.setName("pankaj1");
		emp.setSal(6000);
		emp.setJoiningDate(new Date());
		
		Address address1=new Address();
		address1.setCity("Gwalior");
		address1.setPincode("1234");
		address1.setState("MP");
		address1.setStreet("abc");

		Address address2=new Address();
		address2.setCity("Delhi");
		address2.setPincode("3123");
		address2.setState("Delhi");
		address2.setStreet("Saket");
		
		// add phone
		
		Phone phone1=new Phone();
		phone1.setFirstName("rahul");
		phone1.setLastName("Singh");
		phone1.setPhoneNumber("12345");
		
		// one to one with vehicle
		Vehicle vehicle=new Vehicle();
		vehicle.setVehName("car");
		
		// for One to Many
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehName("bike");
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehName("jeep");
		
		// ArrayList Example
		// for embedded collection
		emp.getListAddr().add(address1);
		emp.getListAddr().add(address2);
		// for embedded ,not a separate class
		emp.setPhone(phone1);
		// one to one
		emp.setVehicle(vehicle);
		// one to many
		emp.getListVeh().add(vehicle1);
		emp.getListVeh().add(vehicle2);
		
		empService.createEmp(emp);
	}
	
	@RequestMapping(name="/getEmpDetails",method=RequestMethod.GET)
	public ModelAndView getEmpDetails(){
		System.out.println("getEmpDetails():::");
		Employee emp=empService.getEmpDetails();
		//emp.getListAddr();
		
		ModelAndView model=new ModelAndView();
		model.setViewName("empDetailsPage");
		model.addObject("emp",emp);
		
		return model;
	}
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView successLogin(){
		System.out.println("EmpController-->successLogin():::");
		ModelAndView model=new ModelAndView();
		model.setViewName("home");
		return model;
	}*/
	
	@RequestMapping(value = { "/homePage"}, method = RequestMethod.GET)
	public ModelAndView homePage() {
		System.out.println("homePage():::");
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		return model;
	}
	
	@RequestMapping(value = { "/adminPage"}, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		System.out.println("adminPage():::");
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPage");
		return model;
	}
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		System.out.println("loginPage():::"+error);
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		model.setViewName("loginPage");
		return model;
	}
	
	@RequestMapping(value="saveVehicleInheritance",method=RequestMethod.GET)
	public void saveVehicleInheritance(){
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehName("car");
		
		FourWheeler car=new FourWheeler();
		car.setVehName("Äudi");
		car.setSteeringWheel("Audi Steering wheel");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehName("pulsar");
		bike.setSteeringHandle("Bajaj Steering handle");
		
		empService.saveVehicleInheritance(vehicle);
		empService.saveVehicleInheritance(bike);
		empService.saveVehicleInheritance(car);
		
		
	}

}
