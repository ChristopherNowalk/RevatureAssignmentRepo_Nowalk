package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;
import dev.nowalk.repositories.DepartmentRepo;

public class DepartmentServicesImpl implements DepartmentServices {

	public DepartmentRepo dr;
	
	public  DepartmentServicesImpl(DepartmentRepo dr) {
		this.dr = dr;
	}
	
	@Override
	public void addDepartment(Department d) {
		dr.addDepartment(d);
	}

	@Override
	public List<Department> getAllDepartments() {
		return dr.getAllDepartments();
	}

	@Override
	public Department getDepartmentById(int id) {
		return dr.getDepartment(id);
	}

	@Override
	public Department updateDepartment(Department change) {
		return dr.updateDepartment(change);
	}

	@Override
	public Department deleteDepartment(Department d) {
		return dr.deleteDepartment(d);
	}

	@Override
	public Department setDepartmentHead(Department d, Employee e) {
		int e_id = e.getE_id();
		d.setDep_head(e_id);
		return d;
	}

	@Override
	public Department getDepartmentByName(String name) {
		return dr.getDepartmentByName(name);
	}

}
