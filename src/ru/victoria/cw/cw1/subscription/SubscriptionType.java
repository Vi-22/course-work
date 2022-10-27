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
        this.time = time;
    }

    public VisitZone getZone() {
        return zone;
    }

    public void setZone(VisitZone zone) {
        this.zone = zone;
    }
}
