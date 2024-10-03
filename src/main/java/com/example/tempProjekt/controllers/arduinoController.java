package com.example.tempProjekt.controllers;

import com.example.tempProjekt.Services.humidityService;
import com.example.tempProjekt.Services.tempService;
import com.example.tempProjekt.models.Input;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arduino")
@CrossOrigin("*")
public class arduinoController {

  private final tempService tempService;
  private final humidityService humidityService;

  public arduinoController(
    tempService tempService,
    humidityService humidityService
  ) {
    this.tempService = tempService;
    this.humidityService = humidityService;
  }

  @SubscribeMapping("/latest")
  public String subscribeToLatest() {
    System.out.println("A client is subscribing to /latest");
    return "You are now subscribed to /latest";
  }

  @PostMapping("/input")
  @MessageMapping("/input")
  @SendTo("/latest")
  public String receiveTemperatureAndHumidity(@RequestBody Input input) {
    System.out.println(input.getTemperature() + " " + input.getHumidity());
    tempService.newTemp(input.getTemperature());
    humidityService.newHumidity(input.getHumidity());

    return "Temperature and humidity received successfully.";
  }
}
