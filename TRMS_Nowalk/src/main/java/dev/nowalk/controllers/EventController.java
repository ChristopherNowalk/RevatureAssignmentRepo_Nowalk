package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.Event;
import dev.nowalk.models.EventType;
import dev.nowalk.models.GradingFormat;
import dev.nowalk.services.EventServices;
import dev.nowalk.services.EventTypeServices;
import dev.nowalk.services.GradingFormatServices;
import io.javalin.http.Handler;

public class EventController {

	public EventServices es;
	public EventTypeServices ets;
	public GradingFormatServices gfs;
	Gson gson = new Gson();
	
	public EventController (EventServices es, EventTypeServices ets, GradingFormatServices gfs) {
		this.es = es;
		this.ets = ets;
		this.gfs = gfs;
	}
	
	public Handler addEvent = (context) -> {
		Event ev = gson.fromJson(context.body(), Event.class);
		es.addEvent(ev);
		if(ev != null) {
			context.status(201);
		} else {
			context.status(400);
		}
	};
	
	public Handler getAllEvents = (context) -> {
		List<Event> events = es.getAllEvents();
		context.result(gson.toJson(events));
	};
	
	public Handler getEventById = (context) -> {
		
	};
	
	public Handler getEventByName = (context) -> {
		String input = context.pathParam("event_name");
		Event ev = es.getEvent(input);
		
		if(ev != null) {
			context.result(gson.toJson(ev));
		} else {
			context.status(404);
		}
	};
	
	public Handler updateEvent = (context) -> {
		
	};
	
	public Handler deleteEvent = (context) -> {
		
	};
	
	public Handler addEventTypeToEvent = (context) -> {
		String ev = context.pathParam("ev_id");
		String evt = context.pathParam("et_id");
		
		int ev_id;
		int et_id;
		try {
			ev_id = Integer.parseInt(ev);
			et_id = Integer.parseInt(evt);
		} catch (NumberFormatException e) {
			ev_id = -1;
			et_id = -1;
		}
		Event e = es.getEvent(ev_id);
		EventType et = ets.getEventType(et_id);
		
		e = es.addEventTypeToEvent(e, et);
		e = es.updateEvent(e);
		if(e != null) {
			context.result(gson.toJson(e));
		} else {
			context.status(404);
		}
		
	};
	
	public Handler addGradingFormatToEvent = (context) -> {
		String ev = context.pathParam("ev_id");
		String g = context.pathParam("gf_id");
		
		int ev_id;
		int gf_id;
		try {
			ev_id = Integer.parseInt(ev);
			gf_id = Integer.parseInt(g);
		} catch (NumberFormatException e) {
			ev_id = -1;
			gf_id = -1;
		}
		Event e = es.getEvent(ev_id);
		GradingFormat gf = gfs.getGradingFormat(gf_id);
		
		e = es.addGraingFormatToEvent(e, gf);
		e = es.updateEvent(e);
		if(e != null) {
			context.result(gson.toJson(e));
		} else {
			context.status(404);
		}
	};
	
}
