package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String processSurvey(Survey survey, RedirectAttributes flashScope) {
		String message = "Thank you for completing our survey!";
		surveyDao.save(survey);
		flashScope.addFlashAttribute("thanks", message);
		return "redirect:/favoritePark";
	}

	
}
