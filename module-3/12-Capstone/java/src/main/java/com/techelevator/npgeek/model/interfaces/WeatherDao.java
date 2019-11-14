package com.techelevator.npgeek.model.interfaces;

import java.util.List;

import com.techelevator.npgeek.Weather;

public interface WeatherDao {

	public List<Weather> getWeatherByParkCode(String parkCode);
	
}
