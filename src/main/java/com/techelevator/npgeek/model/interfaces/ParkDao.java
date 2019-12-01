package com.techelevator.npgeek.model.interfaces;

import java.util.List;

import com.techelevator.npgeek.Park;

public interface ParkDao {

	public List<Park> getAllParks();
	public Park getParkByCode(String parkCode);
	public List<Park> sortFavoritePark();
}
