package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.interfaces.WeatherDao;

@Controller
public class WeatherController {

	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping("/parkWeather")
	public String displayWeatherDetails(@RequestParam String id, ModelMap modelMap, HttpSession session) {
		
		return "parkWeather";
	}

}
