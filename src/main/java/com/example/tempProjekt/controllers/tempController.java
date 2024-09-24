package com.example.tempProjekt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tempProjekt.Services.tempService;
import com.example.tempProjekt.models.Temp;

@RestController
public class tempController {

    @Autowired
    private tempService tempService;

    @GetMapping("/temp/today")
    public List<Temp> getTemperature() {

        return tempService.getTodaysTemps();
    }

    @GetMapping("/temp/hour")
    public List<Temp> getTemperatureForLastHour() {
        return tempService.getTempsForHour();
    }
}
