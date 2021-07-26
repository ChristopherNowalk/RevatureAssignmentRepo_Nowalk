package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_types")
public class EventType {

	@Id
	@Column(name="et_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int et_id;
	@Column(name="coverage_percent")
	private int coverage_percent;
	@Column(name="event_type")
	private String event_type;
	
	public EventType() {
		super();
	}

	public EventType(int et_id, int coverage_percent, String event_type) {
		super();
		this.et_id = et_id;
		this.coverage_percent = coverage_percent;
		this.event_type = event_type;
	}

	public EventType(int coverage_percent, String event_type) {
		super();
		this.coverage_percent = coverage_percent;
		this.event_type = event_type;
	}

	public int getEt_id() {
		return et_id;
	}

	public void setEt_id(int et_id) {
		this.et_id = et_id;
	}

	public int getCoverage_percent() {
		return coverage_percent;
	}

	public void setCoverage_percent(int coverage_percent) {
		this.coverage_percent = coverage_percent;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	@Override
	public String toString() {
		return "EventType [et_id=" + et_id + ", coverage_percent=" + coverage_percent + ", event_type=" + event_type
				+ "]";
	}
	
	
}
