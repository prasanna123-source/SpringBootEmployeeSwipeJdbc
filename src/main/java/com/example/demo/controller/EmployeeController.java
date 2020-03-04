package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.model.Employee;
@Controller
public class EmployeeController {

@Autowired
EmployeeDaoImpl employeeDaoRef;

	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeDaoRef.listEmployeess());
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/getEmployeeByID", method = RequestMethod.GET)
	public ModelAndView getEmployeeById(String empid, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeDaoRef.getEmployeeById(empid));
		return new ModelAndView("getEmployeebyID", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}	
	public List<Employee> getEmployeeByLocation(String location,String user){
		if(user.equalsIgnoreCase("admin")) {
		return employeeDaoRef.getAdminEmployeeByLocation(location);
		}else {
		return employeeDaoRef.listEmployeess();
		}
	}
	
	public List<Employee> getEmployeeByDate(String date,String user){
		if(user.equalsIgnoreCase("admin")) {
		return employeeDaoRef.getAdminEmployeeByDate(date);
		}else {
		return employeeDaoRef.listEmployeess();
		}
	}
	
}
