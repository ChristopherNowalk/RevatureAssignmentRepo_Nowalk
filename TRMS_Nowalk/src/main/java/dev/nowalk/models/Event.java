package dev.nowalk.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {

	@Id
	@Column(name="ev_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ev_id;
	@Column(name="event_name")
	private String event_name;
	@ManyToOne
	@JoinColumn(name="event_type")
	private EventType event_type;
	@ManyToOne
	@JoinColumn(name="grading_format")
	private GradingFormat grading_format;
	@Column(name="cost")
	private int cost;
	@Column(name="start_date")
	private int start_date;
	@Column(name="end_date")
	private int end_date;
	@Column(name="description")
	private String description;
	
	public Event() {
		super();
	}

	public Event(int ev_id, String event_name, EventType event_type, GradingFormat grading_format, int cost, int start_date, int end_date,
			String description) {
		super();
		this.ev_id = ev_id;
		this.event_name = event_name;
		this.event_type = event_type;
		this.cost = cost;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
		this.grading_format = grading_format;
	}

	public Event(String event_name, EventType event_type, GradingFormat grading_format, int cost, int start_date, int end_date, String description) {
		super();
		this.event_name = event_name;
		this.event_type = event_type;
		this.cost = cost;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
		this.grading_format = grading_format;
	}

	public int getEv_id() {
		return ev_id;
	}

	public void setEv_id(int ev_id) {
		this.ev_id = ev_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public EventType getEvent_type() {
		return event_type;
	}

	public void setEvent_type(EventType event_type) {
		this.event_type = event_type;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStart_date() {
		return start_date;
	}

	public void setStart_date(int start_date) {
		this.start_date = start_date;
	}

	public int getEnd_date() {
		return end_date;
	}

	public void setEnd_date(int end_date) {
		this.end_date = end_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public GradingFormat getGrading_format() {
		return grading_format;
	}

	public void setGrading_format(GradingFormat grading_format) {
		this.grading_format = grading_format;
	}

	@Override
	public String toString() {
		return "Event [ev_id=" + ev_id + ", event_name=" + event_name + ", event_type=" + event_type + ", cost=" + cost
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", description=" + description + "]";
	}
	
	
}
