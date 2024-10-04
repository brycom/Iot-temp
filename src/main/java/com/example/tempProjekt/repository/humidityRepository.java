package com.example.tempProjekt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.tempProjekt.models.Humidity;

public interface humidityRepository extends CrudRepository<Humidity, Integer> {

    @Query("SELECT h FROM Humidity h WHERE h.date = ?1")
    List<Humidity> todaysHumidity(String date);

    @Query("SELECT h FROM Humidity h WHERE h.date = ?1 AND h.time LIKE ?2%")
    List<Humidity> humidityForHour(String date, int timeString);

    @Query("SELECT h FROM Humidity h WHERE h.date =?1")
    List<Humidity> humidityForDate(String date);

}
