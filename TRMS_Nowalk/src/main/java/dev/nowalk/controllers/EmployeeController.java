package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;
import dev.nowalk.models.Request;
import dev.nowalk.services.DepartmentServices;
import dev.nowalk.services.EmployeeServices;
import dev.nowalk.services.RequestServices;
import io.javalin.http.Handler;

public class EmployeeController {

	public EmployeeServices es;
	public DepartmentServices ds;
	public RequestServices rs;
	Gson gson = new Gson();
	
	public EmployeeController(EmployeeServices es, DepartmentServices ds, RequestServices rs) {
		this.es = es;
		this.ds = ds;
		this.rs = rs;
	}
	
	public Handler getAllEmployees = (context) -> {
		List<Employee> employees = es.getAllEmployees();
		context.result(gson.toJson(employees));
	};
	
	public Handler getEmployeeByName = (context) -> {
		String name = context.queryParam("name");
		
		Employee e = es.getEmployeeByName(name);
		
		if( e != null) {
			context.result(gson.toJson(e));
		} else {
			context.result("{}");
		}
	};
	
	public Handler getEmployeeById = (context) -> {
		String input = context.pathParam("e_id");
		int e_id;
		try {
			e_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e_id = -1;
		}
		Employee em = es.getEmployeeById(e_id);
		if(em != null) {
			context.result(gson.toJson(em));
		} else {
			context.status(404);
		}
	};
	
	public Handler getEmployeeByRequestId = (context) -> {
		String input = context.pathParam("r_id");
		Employee em = null;
		int r_id;
		try {
			r_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			r_id = -1;
		}
		em = es.getEmployeeFromRequestID(r_id);
		if(em != null) {
			context.result(gson.toJson(em));
		} else {
			context.status(404);
		}
	};
	
	public Handler addEmployee = (context) -> {
		Employee e = gson.fromJson(context.body(), Employee.class);
		
		es.addEmployee(e);
		
		if(e != null) {
			context.result(gson.toJson(e));
		} else {
			context.result(gson.toJson("{}"));
		}
	};
	
	public Handler updateEmployee = (context) -> {
		Employee e = gson.fromJson(context.body(), Employee.class);
		
		es.updateEmployee(e);
		
		if(e != null) {
			context.result(gson.toJson(e));
		} else {
			context.result("{}");
		}
	};
	
	public Handler deleteEmployee = (context) -> {
		Employee e = gson.fromJson(context.body(), Employee.class);
		
		es.deleteEmployee(e);
		
		if(e != null) {
			context.result(gson.toJson(e));
		} else {
			context.status(404);
		}
	};
	
	public Handler setDepartment = (context) -> {
		String em = context.pathParam("e_name");
		String dep = context.pathParam("d_name");
		
		Employee e = es.getEmployeeByName(em);
		
		Department d = ds.getDepartmentByName(dep);
		
		if(e != null & d != null) {
			es.setDepartment(e, d);
			es.updateEmployee(e);
			context.result(gson.toJson(e));
		} else {
			context.status(404);
		}
	};
	
	public Handler submitNewRequest = (context) -> {
		String em = context.pathParam("name");
		//String re = context.pathParam("r_id");
		System.out.println(context.body());
		Request r = null;
		try {
			r = gson.fromJson(context.body(), Request.class);
		} catch (IllegalStateException | JsonSyntaxException ex) {
			ex.printStackTrace();
			r = null;
		}

//		int r_id;
//		try {
//			r_id = Integer.parseInt(re);
//		} catch (NumberFormatException e) {
//			r_id = -1;
//		}
//		Request r = rs.getRequestById(r_id);
		Employee e = es.getEmployeeByName(em);
		es.submitNewRequest(e, r);
		if(e != null & r != null) {
			//r = rs.addEmployeeToRequest(r, e);
			context.result(gson.toJson(e));
		} else {
			context.status(404);
		}
	};
	
	public Handler setBenCoId = (context) -> {
		//Employee em = gson.fromJson(context.body(), Employee.class);
		String em = context.pathParam("e_id");
		String input = context.pathParam("bc_id");
		
		int bc_id;
		int e_id;
		try {
			bc_id = Integer.parseInt(input);
			e_id = Integer.parseInt(em);
		} catch (NumberFormatException e) {
			bc_id = -1;
			e_id = -1;
		}
		Employee emp = es.getEmployeeById(e_id);
		Employee bc = es.getEmployeeById(bc_id);
		es.setBenCoId(emp, bc);
		if (em != null) {
			context.result(gson.toJson(emp));
		} else {
			context.status(404);
		}
	};
	
	public Handler setSuperId = (context) -> {
		//Employee em = gson.fromJson(context.body(), Employee.class);
		String em = context.pathParam("e_id");
		String input = context.pathParam("s_id");
		
		int s_id;
		int e_id;
		try {
			s_id = Integer.parseInt(input);
			e_id = Integer.parseInt(em);
		} catch (NumberFormatException e) {
			s_id = -1;
			e_id = -1;
		}
		Employee emp = es.getEmployeeById(e_id);
		Employee s = es.getEmployeeById(s_id);
		es.setSuperId(emp, s);
		if (em != null) {
			context.result(gson.toJson(emp));
		} else {
			context.status(404);
		}
	};
	
	public Handler getAllEmployeesUnderSuper = (context) -> {
		String input = context.pathParam("e_id");
		int e_id;
		try {
			e_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e_id = -1;
		}
		Employee em = es.getEmployeeById(e_id);
		List<Employee> employees = es.getAllEmployeesUnderSuper(em);
		if(employees != null) {
			context.result(gson.toJson(employees));
		} else {
			context.status(404);
		}
	};
	
	public Handler getAllEmployeesUnderBenCo = (context) -> {
		String input = context.pathParam("e_id");
		int e_id;
		try {
			e_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e_id = -1;
		}
		Employee em = es.getEmployeeById(e_id);
		List<Employee> employees = es.getAllEmployeesUnderBenCo(em);
		if(employees != null) {
			context.result(gson.toJson(employees));
		} else {
			context.status(404);
		}
	};
}
