package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Award;

public interface AwardRepo {

	public void addAward(Award a);
	
	public List<Award> getAllAwards();
	
	public Award getAward(int id);
	
	public Award updateAward(Award change);
	
	public Award deleteAward(Award a);
	
}
