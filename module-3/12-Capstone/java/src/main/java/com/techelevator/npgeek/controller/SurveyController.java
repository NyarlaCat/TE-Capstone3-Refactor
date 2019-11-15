package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.model.interfaces.ParkDao;
import com.techelevator.npgeek.model.interfaces.SurveyDao;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDao surveyDao;
	
	@Autowired
	private ParkDao parkDao;
	
	@RequestMapping("/survey")
	public String displaySurvey( ModelMap modelMap ) {

		List<Park> park = parkDao.getAllParks();
		modelMap.put("surveyPark", park);
		return "survey";
		
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String processSurvey(Survey survey) {
		surveyDao.save(survey);
		return "redirect:/favoritePark";
	}

	
}
