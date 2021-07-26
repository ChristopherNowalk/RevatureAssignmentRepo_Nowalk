package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Event;
import dev.nowalk.models.Request;

public interface RequestRepo {

public void addRequest (Request r);
	
	public List<Request> getAllRequests();
	
	public Request getRequest(int id);
	
	public Request updateRequest(Request r);
	
	public Request deleteRequest(Request r);

}
