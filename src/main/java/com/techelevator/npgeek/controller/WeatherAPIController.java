package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.Weather;
import com.techelevator.npgeek.model.interfaces.WeatherDao;

import java.util.List;

import org.springframework.web.bind.annotation.*;

// This line tells Spring that this reruns data and not JSP
@RestController
// Sets the base url for the page
@RequestMapping("/api/weather")
public class WeatherAPIController {
    // This declares what DAO (Data access object) the controller has access to.
    // This is what gets keyed into for logic that retrieves data
    private final WeatherDao weatherDao;

    // This is the constructor which initializes the DAO for use
    public WeatherAPIController(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    // Endpoint method:
    // @GetMapping Tells spring to handle this as an http get
    // request and provides it with a path param that will become
    // accessible with @PathVariable which will bind that target
    // to a variable called id
    @GetMapping("/{id}")
    public List<Weather> getWeatherForParkByPath(@PathVariable String id) {
        // Call this method on the DAO.
        // This is doing almost the same as line 29 of WeatherController.java the
        // difference is that it's returning it instead of assigning it to a variable
        return weatherDao.getWeatherByParkCode(id);
    }
}
