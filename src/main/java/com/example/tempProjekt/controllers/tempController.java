package com.example.tempProjekt.controllers;

import com.example.tempProjekt.Services.TempService;
import com.example.tempProjekt.models.Humidity;
import com.example.tempProjekt.models.Temp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class tempController {

  @Autowired
  private TempService tempService;

  @GetMapping("/temp/today")
  public List<Temp> getTemperature() {
    return tempService.getTodaysTemps();
  }

  @GetMapping("/temp/hour")
  public List<Temp> getTemperatureForLastHour() {
    return tempService.getTempsForHour();
  }

  @GetMapping("/temp/{date}")
  public List<Temp> getTempForDate(@PathVariable String date) {
    System.out.println("getTemp WOGELI BOGELI GUBB FAN: " + date + "\n" + tempService.getTempForDate(date).size());
    return tempService.getTempForDate(date);
  }
}
