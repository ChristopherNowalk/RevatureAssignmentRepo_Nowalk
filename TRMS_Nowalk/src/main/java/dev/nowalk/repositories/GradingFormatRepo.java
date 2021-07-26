package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.GradingFormat;

public interface GradingFormatRepo {

	public void addGradingFormat(GradingFormat gf);
	
	public List<GradingFormat> getAllGradingFormats();
	
	public GradingFormat getGradingFormat(int id);
	
	public GradingFormat getGradingFormat(String type);
	
	public GradingFormat updateGradingFormat(GradingFormat change);
	
	public GradingFormat deletGradingFormat(GradingFormat gf);
}
