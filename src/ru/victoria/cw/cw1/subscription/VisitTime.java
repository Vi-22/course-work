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

    private void setFromTime(LocalTime fromTime) {
        if (fromTime==null) {
            throw new IllegalArgumentException("fromTime не может быть null");
        }
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    private void setToTime(LocalTime toTime) {
        if (toTime==null) {
            throw new IllegalArgumentException("to time не может быть null");
        }
        this.toTime = toTime;
    }

}

