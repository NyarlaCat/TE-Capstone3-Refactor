package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.interfaces.ParkDao;

@Controller
public class HomePageController {
	
	@Autowired
	private ParkDao parkDao;
	@RequestMapping(path= {"/","/home"})
	public String displayHomePage(HttpSession session) {

		List<Park> park = parkDao.getAllParks();
		session.setAttribute("park", park);
		
		return "home";
	}
}
