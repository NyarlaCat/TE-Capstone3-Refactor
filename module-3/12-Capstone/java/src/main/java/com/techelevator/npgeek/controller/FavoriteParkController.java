package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.FavoritePark;
import com.techelevator.npgeek.model.interfaces.FavoriteParkDao;

@Controller
public class FavoriteParkController {
	
	@Autowired
	private FavoriteParkDao favoriteParkDao;

	@RequestMapping("/favoritePark")
	public String showFavoriteParks(ModelMap modelMap) {

		List<FavoritePark> favoriteParks = favoriteParkDao.getTopVotedParks();
		
		modelMap.put("favorites", favoriteParks);
		
		return "favoritePark";
	}


	@RequestMapping("/sessionExpire")
	public String sessionExpire(HttpSession session) {
		session.invalidate();
		return"expire";
		}
}
