package com.example.tempProjekt.controllers;

import com.example.tempProjekt.Services.HumidityService;
import com.example.tempProjekt.models.Humidity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class humidityController {

  @Autowired
  private HumidityService humidityService;

  @GetMapping("/humidity/today")
  public List<Humidity> getHumidity() {
    return humidityService.getTodaysHumidity();
  }

  @GetMapping("/humidity/hour")
  public List<Humidity> getHumidityForHour() {
    return humidityService.getHumidityForHour();
  }

  @GetMapping("/humidity/{date}")
  public List<Humidity> getHumidityForDate(@PathVariable String date) {
    return humidityService.getHumidityForDate(date);
  }
}
