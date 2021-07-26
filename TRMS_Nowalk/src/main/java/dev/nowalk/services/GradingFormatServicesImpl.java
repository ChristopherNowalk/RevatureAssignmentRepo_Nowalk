package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.GradingFormat;
import dev.nowalk.repositories.GradingFormatRepo;

public class GradingFormatServicesImpl implements GradingFormatServices {

	public GradingFormatRepo gfr;
	
	public GradingFormatServicesImpl(GradingFormatRepo gfr) {
		this.gfr = gfr;
	}
	
	@Override
	public void addGradingFormat(GradingFormat gf) {		
		gfr.addGradingFormat(gf);
	}

	@Override
	public List<GradingFormat> getAllGradingFormats() {	
		return gfr.getAllGradingFormats();
	}

	@Override
	public GradingFormat getGradingFormat(int id) {	
		return gfr.getGradingFormat(id);
	}

	@Override
	public GradingFormat getGradingFormat(String type) {
		return gfr.getGradingFormat(type);
	}

	@Override
	public GradingFormat updateGradingFormat(GradingFormat change) {
		return gfr.updateGradingFormat(change);
	}

	@Override
	public GradingFormat deleteGradingFormat(GradingFormat gf) {
		return gfr.deletGradingFormat(gf);
	}

}
