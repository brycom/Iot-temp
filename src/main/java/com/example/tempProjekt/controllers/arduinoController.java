package com.example.tempProjekt.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tempProjekt.Services.humidityService;
import com.example.tempProjekt.Services.tempService;
import com.example.tempProjekt.models.Input;

@RestController
@RequestMapping("/arduino")
public class arduinoController {

    private final tempService tempService;
    private final humidityService humidityService;

    public arduinoController(tempService tempService, humidityService humidityService) {
        this.tempService = tempService;
        this.humidityService = humidityService;
    }

    @PostMapping("/input")
    public String receiveTemperatureAndHumidity(@RequestBody Input input) {
        System.out.println(input.getTemperature() + " " + input.getHumidity());
        tempService.newTemp(input.getTemperature());
        humidityService.newHumidity(input.getHumidity());

        return "Temperature and humidity received successfully.";
    }
}
