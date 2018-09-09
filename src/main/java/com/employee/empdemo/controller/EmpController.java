package com.employee.empdemo.controller;

import java.util.List;

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

import com.employee.empdemo.enity.Employee;
import com.employee.empdemo.service.EmpServiceImpl;

@Controller
public class EmpController {
	
	@Autowired
	EmpServiceImpl empService;
	
	@RequestMapping(value="/getEmpDetails",method=RequestMethod.GET)
	public Employee getEmpDetails(){
		System.out.println("getEmpDetails()::");
		return empService.getEmpDetails();
	}
	
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
		empService.createEmp(employee);
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


}
