package com.example.trialapp;

public class ScheduleDataModel {
    private String title;
    private String date;
    private String time;

    public ScheduleDataModel(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
