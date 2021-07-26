package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	//TODO: make a new request with the ben co approval actually on the request, the current table in the database does not have this on it
	@Id
	@Column(name="req_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int req_id;	
	@Column(name="is_urgent")
	private boolean is_urgent;
	@ManyToOne
	@JoinColumn(name="event")
	private Event event;
	@Column(name="message")
	private String message;
	@Column(name="super_approval")
	private boolean super_approval;
	@Column(name="dep_head_approval")
	private boolean dep_head_approval;
	@Column(name="ben_co_approval")
	private boolean ben_co_approval;
	
	public Request() {
		super();
	}

	public Request(int req_id, boolean is_urgent, Event event, String message,
			boolean super_approval, boolean dep_head_approval, boolean ben_co_approval) {
		super();
		this.req_id = req_id;
		this.is_urgent = is_urgent;
//		this.employee = employee;
		this.event = event;
		this.message = message;
		this.super_approval = super_approval;
		this.dep_head_approval = dep_head_approval;
		this.ben_co_approval = ben_co_approval;
	}

	public Request(boolean is_urgent, Event event, String message, boolean super_approval,
			boolean dep_head_approval, boolean ben_co_approval) {
		super();
		this.is_urgent = is_urgent;
//		this.employee = employee;
		this.event = event;
		this.message = message;
		this.super_approval = super_approval;
		this.dep_head_approval = dep_head_approval;
		this.ben_co_approval = ben_co_approval;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public boolean isIs_urgent() {
		return is_urgent;
	}

	public void setIs_urgent(boolean is_urgent) {
		this.is_urgent = is_urgent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuper_approval() {
		return super_approval;
	}

	public void setSuper_approval(boolean super_approval) {
		this.super_approval = super_approval;
	}

	public boolean isDep_head_approval() {
		return dep_head_approval;
	}

	public void setDep_head_approval(boolean dep_head_approval) {
		this.dep_head_approval = dep_head_approval;
	}
	
	
	public boolean isBen_co_approval() {
		return ben_co_approval;
	}

	public void setBen_co_approval(boolean ben_co_approval) {
		this.ben_co_approval = ben_co_approval;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Request [req_id=" + req_id + ", is_urgent=" + is_urgent + ", event=" + event + ", message=" + message
				+ ", super_approval=" + super_approval + ", dep_head_approval=" + dep_head_approval + "]";
	}

	
	
	
}