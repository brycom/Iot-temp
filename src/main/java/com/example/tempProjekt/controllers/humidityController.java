package com.example.tempProjekt.controllers;

import java.util.List;

import com.example.tempProjekt.models.Humidity;
import com.example.tempProjekt.Services.humidityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class humidityController {

    @Autowired
    private humidityService humidityService;

    @GetMapping("/humidity/today")
    public List<Humidity> getHumidity() {
        return humidityService.getTodaysHumidity();
    }

    @GetMapping("/humidity/hour")
    public List<Humidity> getHumidityForHour() {
        return humidityService.getHumidityForHour();
    }
}
