package com.bluetree.springbootbluetreecom.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bluetree.springbootbluetreecom.model.Employee;
import com.bluetree.springbootbluetreecom.service.EmployeeService;
@Controller
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
		return"index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	//creating model attribute to bind from data
	{
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	//save employee to database
	
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}
	@GetMapping("/showFormForEdit/{id}")
	public String showFormForEdit(@PathVariable( value="id")long id,Model model)
	{
		//getting employee from the service
		Employee employee = employeeService.getEmployeeById(id);
	
		model.addAttribute("employee",employee);
		return"edit_employee";	
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable( value="id")long id)
	{
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
	

}

