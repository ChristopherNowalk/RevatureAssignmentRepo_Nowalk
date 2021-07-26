package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;

public interface DepartmentServices {

	public void addDepartment(Department d);
	
	public List<Department> getAllDepartments();
	
	public Department getDepartmentById(int id);
	
	public Department updateDepartment(Department change);
	
	public Department deleteDepartment(Department d);
	
	public Department setDepartmentHead(Department d, Employee e);
	
	public Department getDepartmentByName(String name);
}
