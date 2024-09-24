package com.example.tempProjekt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Temp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float temp;
    private String time;
    private String date;

    public Temp(float temp, String time, String date) {
        this.temp = temp;
        this.time = time;
        this.date = date;
    }

    public Temp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
