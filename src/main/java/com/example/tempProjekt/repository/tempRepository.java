package com.example.tempProjekt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.tempProjekt.models.Temp;

public interface tempRepository extends CrudRepository<Temp, Integer> {

    @Query("SELECT t FROM Temp t WHERE t.date = ?1")
    List<Temp> todaysTemp(String date);

    @Query("SELECT t FROM Temp t WHERE t.date = ?1 AND t.time LIKE ?2%")
    List<Temp> tempsForHour(String date, int time);

    /*     @Query(value = "select t From temp Order BY t.id DESC LIMIT")
    Temp findLatestTemp();
     */
}
