package ru.victoria.cw.cw1.subscription;

import java.time.LocalTime;

public enum SubscriptionType {
    ONE_DAY(new VisitTime(LocalTime.of(8,0), LocalTime.of(22,0)), new VisitZone(true, true,false)),
    DAY(new VisitTime(LocalTime.of(8,0), LocalTime.of(16,0)), new VisitZone(true, false, true)),
    FULL(new VisitTime(LocalTime.of(8,0), LocalTime.of(22,0)), new VisitZone(true,true,true));

    private VisitTime time;
    private VisitZone zone;

    SubscriptionType(VisitTime time, VisitZone zone) {
        this.setTime(time);
        this.setZone(zone);
    }

    public VisitTime getTime() {
        return time;
    }

    public void setTime(VisitTime time) {
        if (time == null) {
            throw new IllegalArgumentException("time не может быть null");
        }
        this.time = time;
    }

    public VisitZone getZone() {
        return zone;
    }

    public void setZone(VisitZone zone) {
        if (zone==null) {
            throw new IllegalArgumentException("zone не может быть null");
        }
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "тип - " + this.name();
    }
}
