package com.example.tempProjekt.Services;

import com.example.tempProjekt.models.Humidity;
import com.example.tempProjekt.repository.humidityRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HumidityService {

  private final humidityRepository humidityRepository;
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

  public HumidityService(humidityRepository humidityRepository) {
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
    String date = LocalDate.now().toString();
    return humidityRepository.todaysHumidity(date);
  }

  public List<Humidity> getHumidityForHour() {
    String date = LocalDate.now().toString();
    LocalTime time = LocalTime.now();
    int hour = time.getHour();

    return humidityRepository.humidityForHour(date, hour);
  }

  public List<Humidity> getHumidityForDate(String date) {
    return humidityRepository.humidityForDate(date);
  }
}
