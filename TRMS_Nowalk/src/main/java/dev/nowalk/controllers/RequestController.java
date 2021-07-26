package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.Employee;
import dev.nowalk.models.Event;
import dev.nowalk.models.Request;
import dev.nowalk.services.EmployeeServices;
import dev.nowalk.services.EventServices;
import dev.nowalk.services.RequestServices;
import io.javalin.http.Handler;

public class RequestController {

	public RequestServices rs;
	public EmployeeServices es;
	public EventServices evs;
	public Gson gson = new Gson();
	
	public RequestController(RequestServices rs, EmployeeServices es, EventServices evs) {
		this.rs = rs;
		this.es = es;
		this.evs = evs;
	}
	
	public Handler getAllRequests = (context) -> {
		List<Request> requests = null;
		requests = rs.getAllRequests();
		context.result(gson.toJson(requests));
	};
	
	public Handler addRequest = (context) -> {
		Request r = gson.fromJson(context.body(), Request.class);
		
		rs.addRequest(r);
		if(r != null) {
			context.result(gson.toJson(r));
		} else {
			context.status(400);
		}
	};
	
	//this seems like the most useful handler, each employee should be able to view all of their requests
	public Handler getAllRequestsByEmployee = (context) -> {
		String input = context.pathParam("e_id");
		List<Request> requests = null;
		int e_id;
		try {
			e_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e_id = -1;
		}
		Employee em = es.getEmployeeById(e_id);
		if(em != null) {
			requests = em.getRequests();
			context.result(gson.toJson(requests));
		} else {
			context.status(404);
		}
	};
	
	public Handler getRequestById = (context) -> {
		String input = context.pathParam("r_id");
		int r_id;
		try {
			r_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			r_id = -1;
		}
		Request r = rs.getRequestById(r_id);
		if (r != null) {
			context.result(gson.toJson(r));
		} else {
			context.status(404);
		}
	};
	
	public Handler addEventToRequest = (context) -> {
		//need to think on how I want to handle this event
		String ev = context.pathParam("e_id");
		String req = context.pathParam("r_id");
		int e_id;
		int r_id;
		try {
			e_id = Integer.parseInt(ev);
			r_id = Integer.parseInt(req);
		} catch (NumberFormatException e) {
			e_id = -1;
			r_id = -1;
		}
		Event e = evs.getEvent(e_id);
		Request r = rs.getRequestById(r_id);
		r = rs.addEventToRequest(r, e);
		r = rs.updateRequest(r);
		if(r != null) {		
			context.result(gson.toJson(r));
		} else {
			context.status(404);
		}
		
	};
	
	//for these I should only need the request ID as we get the employee id on the front end
	public Handler setSuperApproval = (context) -> {
		String input = context.pathParam("r_id");
		int r_id;
		
		try {
			r_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			r_id = -1;
		}
		Request r = rs.getRequestById(r_id);
		r = rs.superRequestApproval(r);
		
		if(r != null) {
			context.result(gson.toJson(r));
		} else {
			context.status(404);
		}
	};
	
	public Handler setBenCoApproval = (context) -> {
		String input = context.pathParam("r_id");
		int r_id;
		
		try {
			r_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			r_id = -1;
		}
		Request r = rs.getRequestById(r_id);
		r = rs.bencoRequestApproval(r);
		
		if(r != null) {
			context.result(gson.toJson(r));
		} else {
			context.status(404);
		}
	};
	
	public Handler setDepHeadApproval = (context) -> {
		String input = context.pathParam("r_id");
		int r_id;
		
		try {
			r_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			r_id = -1;
		}
		Request r = rs.getRequestById(r_id);
		r = rs.depHeadRequestApproval(r);
		
		if(r != null) {
			context.result(gson.toJson(r));
		} else {
			context.status(404);
		}
	};
	
	public Handler setIsUrgent = (context) -> {
		String input = context.pathParam("r_id");
		int r_id;
		
		try {
			r_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			r_id = -1;
		}
		Request r = rs.getRequestById(r_id);
		r = rs.setIsUrgent(r);
		
		if(r != null) {
			context.result(gson.toJson(r));
		} else {
			context.status(404);
		}
	};
}
