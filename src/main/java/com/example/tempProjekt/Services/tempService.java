package com.example.tempProjekt.Services;

import com.example.tempProjekt.models.Temp;
import com.example.tempProjekt.repository.tempRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class tempService {

  private final tempRepository tempRepository;

  public tempService(tempRepository tempRepository) {
    this.tempRepository = tempRepository;
  }

  public Temp newTemp(float tempIn) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    String timeString = time.format(formatter);
    Temp temp = new Temp(tempIn, timeString, date.toString());
    return tempRepository.save(temp);
  }

  public Iterable<Temp> getAllTemps() {
    return tempRepository.findAll();
  }

  public List<Temp> getTodaysTemps() {
    String date = /* LocalDate.now().toString() */LocalDate
        .of(2024, 9, 24)
        .toString();

    return tempRepository.todaysTemp(date);
  }

  public List<Temp> getTempsForHour() {
    String date = /* LocalDate.now().toString() */LocalDate
        .of(2024, 9, 24)
        .toString();
    LocalTime time = /* LocalTime.now() */LocalTime.of(14, 15);
    int hour = time.getHour();
    return tempRepository.tempsForHour(date, hour);
  }
}
