package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;

public interface EmployeeRepo {

	public void addEmployee (Employee e);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int id);
	
	public Employee getEmployee(String name);
	
	public Employee updateEmployee(Employee e);
	
	public Employee deleteEmployee(Employee em);
	
	
}
