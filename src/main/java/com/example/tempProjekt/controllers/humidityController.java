package com.example.tempProjekt.controllers;

import com.example.tempProjekt.Services.humidityService;
import com.example.tempProjekt.models.Humidity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class humidityController {

  @Autowired
  private humidityService humidityService;

  @GetMapping("/humidity/today")
  public List<Humidity> getHumidity() {
    return humidityService.getTodaysHumidity();
  }

  @GetMapping("/humidity/hour")
  public List<Humidity> getHumidityForHour() {
    System.out.println("Hej från fukt!");
    return humidityService.getHumidityForHour();
  }
}
