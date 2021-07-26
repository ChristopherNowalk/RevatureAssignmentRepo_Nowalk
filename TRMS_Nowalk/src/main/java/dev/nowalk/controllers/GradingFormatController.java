package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.GradingFormat;
import dev.nowalk.services.GradingFormatServices;
import io.javalin.http.Handler;

public class GradingFormatController {

	public GradingFormatServices gfs;
	Gson gson = new Gson();
	
	public GradingFormatController(GradingFormatServices gfs) {
		this.gfs = gfs;
	}
	
	public Handler addGradingFormat = (context) -> {
		GradingFormat gf = gson.fromJson(context.body(), GradingFormat.class);
		
		gfs.addGradingFormat(gf);
		
		if(gf != null) {
			context.result(gson.toJson(gf));
		} else {
			context.status(400);
		}
	};
	
	public Handler getAllGradingFormats = (context) -> {
		List<GradingFormat> gradingFormats = gfs.getAllGradingFormats();
		context.result(gson.toJson(gradingFormats));
	};
	
	public Handler getGradingFormatById = (context) -> {
		String input = context.pathParam("gf_id");
		int gf_id;
		
		try {
			gf_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			gf_id = -1;
		}
		GradingFormat gf = gfs.getGradingFormat(gf_id);
		
		if(gf != null) {
			context.result(gson.toJson(gf));
		} else {
			context.status(404);
		}
	};
	
	public Handler getGradingFormatByType = (context) -> {
		String type = context.queryParam("grading_type");
		
		GradingFormat gf = gfs.getGradingFormat(type);
		if(gf != null) {
			context.result(gson.toJson(gf));
		} else {
			context.status(404);
		}
	};
	
	public Handler updateGradingFormat = (context) -> {
		GradingFormat gf = gson.fromJson(context.body(), GradingFormat.class);
		
		gfs.updateGradingFormat(gf);
		if(gf != null) {
			context.result(gson.toJson(gf));
		} else {
			context.status(404);
		}
	};
	
	public Handler deleteGradingFormat = (context) -> {
		GradingFormat gf = gson.fromJson(context.body(), GradingFormat.class);
		
		gfs.deleteGradingFormat(gf);
		if(gf != null) {
			context.result(gson.toJson(gf));
		} else {
			context.status(404);
		}
	};
}
