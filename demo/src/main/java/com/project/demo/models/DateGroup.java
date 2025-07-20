package com.project.demo.models;

import java.util.List;

public class DateGroup {
    private String date;
    private List<Task> tasks;

    public DateGroup(String date, List<Task> tasks) {
        this.date = date;
        this.tasks = tasks;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

