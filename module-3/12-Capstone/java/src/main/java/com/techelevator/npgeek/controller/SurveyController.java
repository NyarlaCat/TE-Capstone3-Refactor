package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.model.interfaces.SurveyDao;

@Controller
public class SurveyController {

	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping("/survey")
	public String displaySurvey() {
		return "survey";
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String processSurvey(Survey survey) {
		
		surveyDao.save(survey);
		return "redirect:/favoritePark";
	}

	
}
