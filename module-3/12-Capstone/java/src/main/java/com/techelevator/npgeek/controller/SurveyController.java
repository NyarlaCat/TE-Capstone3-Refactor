package com.techelevator.npgeek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String processSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, RedirectAttributes flashScope) {
		String message = "";
		
		Survey newSurvey = surveyDao.save(survey);
		
		if (newSurvey.getEmail() == null || survey.getEmail().equals("")) {
			message = "Surveys without emails are not processed.";
		} else if (newSurvey.getEmail() != null) {
			message = "Thank you for completing our survey!";
		}
		
		
		flashScope.addFlashAttribute("thanks", message);
		return "redirect:/favoritePark";
	}

	
}
