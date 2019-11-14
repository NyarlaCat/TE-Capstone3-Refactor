package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FavoriteParkController {

	@RequestMapping("/favoritePark")
	public String showFavoriteParks() {
		//there will be methods from a JDBC here to return a list of favorite parks
		return "favoritePark";
	}


}
