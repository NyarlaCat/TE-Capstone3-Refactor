package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.interfaces.ParkDao;

@Controller
public class ParkDetailController {
	@Autowired
	private ParkDao parkDao;

	@RequestMapping("/parkDetail")
	public String showParkDetail(@RequestParam String id, ModelMap modelMap) {
		
		Park displayPark = parkDao.getParkByCode(id);
		
		modelMap.put("parkDetail", displayPark);
		
		return "parkDetail";
	}

}
