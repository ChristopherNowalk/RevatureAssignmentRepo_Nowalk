package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;
import dev.nowalk.models.Request;

public interface EmployeeServices {
	
	public void addEmployee(Employee e);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public Employee getEmployeeByName(String name);
	
	public Employee updateEmployee(Employee change);
	
	public Employee deleteEmployee(Employee e);
	
	//what else do we want an employee to do
	//set their department which they are in
	public Employee setDepartment(Employee e, Department d);
	//submit a new request
	public Request submitNewRequest(Employee e, Request r);
	
	public Employee setBenCoId(Employee e, Employee benco);
	
	public Employee setSuperId(Employee e, Employee supervisor);
	
	public List<Employee> getAllEmployeesUnderSuper(Employee supervisor);
	
	public List<Employee> getAllEmployeesUnderBenCo(Employee benco);
	
	public Employee getEmployeeFromRequestID(int id);
	
//	public Employee addEmployeeToSupervisedEmployees(Employee e, Employee supervisee);
}
