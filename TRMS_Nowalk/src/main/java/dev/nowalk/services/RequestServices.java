package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Employee;
import dev.nowalk.models.Event;
import dev.nowalk.models.Request;

public interface RequestServices {

	public void addRequest(Request r);
	
	public List<Request> getAllRequests();
	
	public Request getRequestById(int id);
	
	public Request updateRequest(Request change);
	
	public Request deleteRequest(Request r);
	
	//we want to add an employee to the request
//	public Request addEmployeeToRequest(Request r, Employee e);
	//we also want to to add an event to the request
	public Request addEventToRequest(Request r, Event e);
	
	public Request superRequestApproval(Request r);
	
	public Request bencoRequestApproval(Request r);
	
	public Request depHeadRequestApproval(Request r);
	
	public Request setIsUrgent(Request r);
	
	public Request getAllRequestsForEmployee(int id);

}
