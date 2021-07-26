package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;
import dev.nowalk.services.DepartmentServices;
import dev.nowalk.services.EmployeeServices;
import io.javalin.http.Handler;

public class DepartmentController {

	public DepartmentServices ds;
	public EmployeeServices es;
	public Gson gson = new Gson();
	public DepartmentController(DepartmentServices ds, EmployeeServices es) {
		this.ds = ds;
		this.es = es;
	}
	
	public Handler getAllDepartments = (context) -> {
		List<Department> departments = null;
		departments = ds.getAllDepartments();
		context.result(gson.toJson(departments));
	};
	
	public Handler getDepartmentById = (context) -> {
		String input = context.pathParam("d_id");
		int d_id;
		try {
			d_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			d_id = -1;
		}
		Department d = ds.getDepartmentById(d_id);
		if(d != null) {
			context.result(gson.toJson(d));
		} else {
			context.status(404);
		}
	};
	
	public Handler getDepartmentByname = (context) -> {
		String dep = context.queryParam("name");
		Department d = ds.getDepartmentByName(dep);
		
		if(d != null) {
			context.result(gson.toJson(d));
		} else {
			context.status(404);
		}
		
	};
	
	public Handler addDepartment = (context) -> {
		Department d = gson.fromJson(context.body(), Department.class);	
		ds.addDepartment(d);
		if(d != null) {
			context.result(gson.toJson(d));
		} else {
			context.result(gson.toJson("{}"));
		}
	};
	
	public Handler updateDepartment = (context) -> {
		
	};
	
	public Handler deleteDepartment = (context) -> {
		
	};
	
	public Handler setDepartmentHead = (context) -> {
		String dep = context.pathParam("d_name");
		String em = context.pathParam("e_name");
		
		Employee e = es.getEmployeeByName(em);
		//Employee e = gson.fromJson(context.body(), Employee.class);
		Department d = ds.getDepartmentByName(dep);
		
		
		if(d != null & e != null) {
			ds.setDepartmentHead(d, e);
			ds.updateDepartment(d);
			context.result(gson.toJson(d));
		} else {
			context.status(404);
		}
		
	};
}
