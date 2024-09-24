package com.example.tempProjekt.models;

public class Input {
    private float temperature;
    private float humidity;

    
    public Input(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public Input() {
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

}
