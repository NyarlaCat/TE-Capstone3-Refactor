package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.interfaces.ParkDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parks")
public class ParkAPIController {

    private final ParkDao parkDao;

    public ParkAPIController(ParkDao parkDao) {
        this.parkDao = parkDao;
    }

    @GetMapping
    public List<Park> getAllParks() {
        return parkDao.getAllParks();
    }
}