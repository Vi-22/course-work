package ru.victoria.cw.cw1.subscription;

import java.time.LocalTime;

public class VisitTime {
    private LocalTime fromTime;
    private LocalTime toTime;
    public VisitTime(LocalTime fromTime, LocalTime toTime) {
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

