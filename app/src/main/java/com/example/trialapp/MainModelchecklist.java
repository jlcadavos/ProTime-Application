package com.example.trialapp;

public class MainModelchecklist {
    String date, title, task, turl;
    MainModelchecklist()
    {

    }
    public MainModelchecklist(String date, String title, String task, String turl) {
        this.date = date;
        this.title = title;
        this.task = task;
        this.turl = turl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }
}
