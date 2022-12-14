package com.bluetree.springbootbluetreecom.service;

import java.util.List;

import com.bluetree.springbootbluetreecom.model.Employee;

public interface EmployeeService 
{
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);

}
