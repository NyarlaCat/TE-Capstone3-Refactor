package com.techelevator.npgeek.model.interfaces;

import java.util.List;

import com.techelevator.npgeek.FavoritePark;

public interface FavoriteParkDao {

	public List<FavoritePark> getTopVotedParks();
}
