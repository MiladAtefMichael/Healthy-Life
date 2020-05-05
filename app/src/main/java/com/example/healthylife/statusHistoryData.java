package com.example.healthylife;

public class statusHistoryData {
    String date;
    String haeartRate;
    String pressure;

    public statusHistoryData(String date, String haeartRate, String pressure) {
        this.date = date;
        this.haeartRate = haeartRate;
        this.pressure = pressure;
    }

    public String getDate() {
        return date;
    }

    public String getHaeartRate() {
        return haeartRate;
    }

    public String getPressure() {
        return pressure;
    }
}

