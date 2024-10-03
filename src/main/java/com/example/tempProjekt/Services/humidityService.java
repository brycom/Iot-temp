package com.example.tempProjekt.Services;

import com.example.tempProjekt.models.Humidity;
import com.example.tempProjekt.repository.humidityRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class humidityService {

  private final humidityRepository humidityRepository;
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

  public humidityService(humidityRepository humidityRepository) {
    this.humidityRepository = humidityRepository;
  }

  public Humidity newHumidity(float humidityin) {
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    String timeString = time.format(formatter);

    Humidity humidity = new Humidity(humidityin, timeString, date.toString());
    return humidityRepository.save(humidity);
  }

  public List<Humidity> getTodaysHumidity() {
    String date = /*  LocalDate.now().toString() */LocalDate
      .of(2024, 9, 24)
      .toString();

    return humidityRepository.todaysHumidity(date);
  }

  public List<Humidity> getHumidityForHour() {
    String date = /* LocalDate.now().toString() */LocalDate
      .of(2024, 9, 24)
      .toString();
    LocalTime time = /* LocalTime.now() */LocalTime.of(14, 15);
    int hour = time.getHour();

    return humidityRepository.humidityForHour(date, hour);
  }
}
