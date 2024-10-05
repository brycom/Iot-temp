package com.example.tempProjekt.controllers;

import com.example.tempProjekt.Services.HumidityService;
import com.example.tempProjekt.Services.TempService;
import com.example.tempProjekt.models.Input;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arduino")
@CrossOrigin("*")
public class ArduinoController {

  private final TempService tempService;
  private final HumidityService humidityService;
  private final SimpMessagingTemplate messagingTemplate;

  public ArduinoController(TempService tempService, HumidityService humidityService,
      SimpMessagingTemplate messagingTemplate) {
    this.tempService = tempService;
    this.humidityService = humidityService;
    this.messagingTemplate = messagingTemplate;
  }

  @SubscribeMapping("/latest")
  public String subscribeToLatest() {
    return "You are now subscribed to /latest";
  }

  @PostMapping("/input")
  public String receiveTemperatureAndHumidity(@RequestBody Input input) {
    System.out.println(input.getTemperature() + " " + input.getHumidity());
    tempService.newTemp(input.getTemperature());
    humidityService.newHumidity(input.getHumidity());

    messagingTemplate.convertAndSend("/latest",
        "{\"temperature\":" + input.getTemperature() + ", \"humidity\":" + input.getHumidity() + "}");

    return "Temperature and humidity received successfully.";
  }

}
