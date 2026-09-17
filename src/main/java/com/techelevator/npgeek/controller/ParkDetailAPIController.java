package com.techelevator.npgeek.controller;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.model.interfaces.ParkDao;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parkDetail")
public class ParkDetailAPIController {

    private final ParkDao parkDao;

    public ParkDetailAPIController(ParkDao parkDao) {
        this.parkDao = parkDao;
    }

    @GetMapping
    public Park getParkDetail(@RequestParam String id) {
        return parkDao.getParkByCode(id);
    }

    @GetMapping("/{id}")
    public Park getParkDetailByPath(@PathVariable String id) {
        return parkDao.getParkByCode(id);
    }
}