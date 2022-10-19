package ru.victoria.cw.cw1.subscription;

import ru.victoria.cw.cw1.access.Time;
import ru.victoria.cw.cw1.access.Zone;

import java.time.LocalTime;

public enum Type {
    ONE_DAY(new Time(LocalTime.of(8,0), LocalTime.of(22,0)), new Zone(true, true,false)),
    DAY(new Time(LocalTime.of(8,0), LocalTime.of(16,0)), new Zone(true, false, true)),
    FULL(new Time(LocalTime.of(8,0), LocalTime.of(22,0)), new Zone(true,true,true));

    private Time time;
    private Zone zone;

    Type(Time time, Zone zone) {
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
