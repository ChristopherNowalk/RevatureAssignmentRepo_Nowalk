package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Department;

public interface DepartmentRepo {

	public void addDepartment(Department d);
	
	public List<Department> getAllDepartments();
	
	public Department getDepartment(int id);
	
	public Department getDepartmentByName(String name);
	
	public Department updateDepartment(Department change);
	
	public Department deleteDepartment(Department d);
}
