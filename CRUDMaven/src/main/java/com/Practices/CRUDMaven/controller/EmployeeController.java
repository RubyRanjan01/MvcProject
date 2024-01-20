package com.Practices.CRUDMaven.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Practices.CRUDMaven.entity.Employee;
import com.Practices.CRUDMaven.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
  
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService=employeeService;
	}
	
	@GetMapping("/list")
	public String findAllEmployees(Model model) {
		List<Employee> employees=employeeService.findAll();
		model.addAttribute("employee", employees);
	   return "employee-list";
		
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "employee-form";
		
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(Model model,@PathVariable int id) {
		Employee employee=employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employee-form";
		
	}	
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(Model model,@PathVariable int id) {
		employeeService.deleteById(id);
		return "redirect:/employee/list";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Model model,@ModelAttribute("employee") Employee employee) {
		employeeService.saveOrUpdate(employee);
		return "redirect:/employee/list";
	}
	
}
