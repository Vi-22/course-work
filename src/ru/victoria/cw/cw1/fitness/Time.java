package ru.victoria.cw.cw1.fitness;

import java.time.LocalTime;

public class Time {
    private LocalTime fromTime;
    private LocalTime toTime;
    public Time(LocalTime fromTime, LocalTime toTime) {
        this.setFromTime(fromTime);
        this.setToTime(toTime);
    }
    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

}

