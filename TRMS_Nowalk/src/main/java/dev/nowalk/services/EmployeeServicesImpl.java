package dev.nowalk.services;

import java.util.ArrayList;
import java.util.List;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;
import dev.nowalk.models.Request;
import dev.nowalk.repositories.EmployeeRepo;
import dev.nowalk.repositories.RequestRepo;

public class EmployeeServicesImpl implements EmployeeServices {

	public EmployeeRepo er;
	public RequestRepo rr;
	
	public EmployeeServicesImpl(EmployeeRepo er, RequestRepo rr) {
		this.er = er;
		this.rr = rr;
	}
	
	public void addEmployee(Employee e) {
		er.addEmployee(e);
	}

	public List<Employee> getAllEmployees() {	
		return er.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return er.getEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee change) {
		return er.updateEmployee(change);
	}

	@Override
	public Employee deleteEmployee(Employee e) {
		return er.deleteEmployee(e);
	}

	@Override
	public Employee getEmployeeByName(String name) {
		return er.getEmployee(name);
	}

	@Override
	public Employee setDepartment(Employee e, Department d) {
		e.setDep(d);
		return e;
	}

	@Override
	public Request submitNewRequest(Employee e, Request r) {		
		List<Request> requests = e.getRequests();
		rr.addRequest(r);
		requests.add(r);
		e.setRequests(requests);
		e = er.updateEmployee(e);
		return r;
	}

	@Override
	public Employee setBenCoId(Employee e, Employee benco) {
		e.setBen_co_id(benco.getE_id());
		e = er.updateEmployee(e);
		return e;
	}

	@Override
	public Employee setSuperId(Employee e, Employee supervisor) {
		e.setSuper_id(supervisor.getE_id());
		e = er.updateEmployee(e);
		return e;
	}

	//now to add this to the employee controller and test it out, if it works then GREAT
	@Override
	public List<Employee> getAllEmployeesUnderSuper(Employee supervisor) {
		List<Employee> employees = er.getAllEmployees();
		List<Employee> employeesUnderSuper = new ArrayList<Employee>();
		//for every employee, look at their supervisor id
		for(int i = 0; i < employees.size(); i++) {
			//if it matches the id of the supervisor employee, add it to the list
			if(employees.get(i).getSuper_id() == supervisor.getE_id()) {
				employeesUnderSuper.add(employees.get(i));
			}
		}
		return employeesUnderSuper;
	}

	@Override
	public List<Employee> getAllEmployeesUnderBenCo(Employee benco) {
		List<Employee> employees = er.getAllEmployees();
		List<Employee> employeesUnderBenCo = new ArrayList<Employee>();
		//for every employee, look at their supervisor id
		for(int i = 0; i < employees.size(); i++) {
			//if it matches the id of the supervisor employee, add it to the list
			if(employees.get(i).getBen_co_id() == benco.getE_id()) {
				employeesUnderBenCo.add(employees.get(i));
			}
		}
		return employeesUnderBenCo;
	}

	@Override
	public Employee getEmployeeFromRequestID(int id) {
		List<Employee> employees = er.getAllEmployees();
		Employee e = null;
		for(int i = 0; i < employees.size(); i++) {
			List<Request> requests = employees.get(i).getRequests();
			for(int j = 0; j < requests.size(); j++) {
				if(requests.get(j).getReq_id() == id) {
					e = employees.get(i);
				}
			}
		}
		return e;
	}

//	@Override
//	public Employee addEmployeeToSupervisedEmployees(Employee e, Employee supervisee) {
//		List<Integer> supervisees = e.getSupervised_employees();
//		supervisees.add(supervisee.getE_id());
//		e = er.updateEmployee(e);
//		return e;
//	}

}
