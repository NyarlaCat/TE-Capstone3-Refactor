package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.model.interfaces.ParkDao;
import com.techelevator.npgeek.model.interfaces.WeatherDao;

@Controller
public class WeatherController {

	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private ParkDao parkDao;
	
	@RequestMapping("/parkWeather")
	public String displayWeatherDetails(@RequestParam String id, ModelMap modelMap, HttpSession session) {
		List<Weather> weather = weatherDao.getWeatherByParkCode(id);
		Park weatherPark = parkDao.getParkByCode(id);
		
		modelMap.put("weatherPark", weatherPark);
		modelMap.put("weather", weather);
		return "parkWeather";
	} 

}
