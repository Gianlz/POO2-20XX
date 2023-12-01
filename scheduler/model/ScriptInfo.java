package com.zugno.scheduler.model;


import java.time.LocalDateTime;

public class ScriptInfo {

    private String name;
    private String description;
    private LocalDateTime scheduleTime;

    public ScriptInfo(String name, String description, LocalDateTime scheduleTime) {
        this.name = name;
        this.description = description;
        this.scheduleTime = scheduleTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
