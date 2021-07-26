package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Employee;
import dev.nowalk.models.Event;
import dev.nowalk.models.Request;
import dev.nowalk.repositories.RequestRepo;

public class RequestServicesImpl implements RequestServices {

	public RequestRepo rr;
	
	public RequestServicesImpl(RequestRepo rr) {
		this.rr = rr;
	}
	
	@Override
	public void addRequest(Request r) {
		rr.addRequest(r);
	}

	@Override
	public List<Request> getAllRequests() {		
		return rr.getAllRequests();
	}

	@Override
	public Request getRequestById(int id) {		
		return rr.getRequest(id);
	}

	@Override
	public Request updateRequest(Request change) {		
		return rr.updateRequest(change);
	}

	@Override
	public Request deleteRequest(Request r) {		
		return rr.deleteRequest(r);
	}


	@Override
	public Request addEventToRequest(Request r, Event e) {
		r.setEvent(e);
		return r;
	}

	@Override
	public Request superRequestApproval(Request r) {
		r.setSuper_approval(true);
		return r = rr.updateRequest(r);
	}

	@Override
	public Request bencoRequestApproval(Request r) {
		r.setBen_co_approval(true);
		return r = rr.updateRequest(r);
		
	}

	@Override
	public Request depHeadRequestApproval(Request r) {
		r.setDep_head_approval(true);
		return r = rr.updateRequest(r);
		
	}

	@Override
	public Request setIsUrgent(Request r) {
		r.setIs_urgent(true);
		return r = rr.updateRequest(r);
	}

	@Override
	public Request getAllRequestsForEmployee(int id) {
		//get all requests
		//sort the ones which are per employee
		return null;
	}

}
