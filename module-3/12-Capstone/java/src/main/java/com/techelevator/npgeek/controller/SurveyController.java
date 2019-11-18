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

	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String showsurveyForm(ModelMap modelMap) {

		List<Park> park = parkDao.getAllParks();
		modelMap.put("surveyParks", park);

		if (!modelMap.containsAttribute("survey")) {
			modelMap.addAttribute("survey", new Survey());
		}

		return "survey";
	}

	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String submitsurveyForm(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes flashScope) {

		if (result.hasErrors()) {
			flashScope.addFlashAttribute("survey", survey);
			flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);

			return "redirect:/survey";
		}
		Survey newSurvey = surveyDao.save(survey);

		String message = "Thank you for completing our survey!";

		flashScope.addFlashAttribute("thanks", message);

		return "redirect:/favoritePark";
	}
}
