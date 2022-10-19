package ru.victoria.cw.cw1.actions;

import ru.victoria.cw.cw1.access.Time;
import ru.victoria.cw.cw1.access.Zone;
import ru.victoria.cw.cw1.subscription.Subscription;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visit {
    private LocalDate visitDate;
    private LocalTime visitTime;
    private Zone visitZone;


    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public LocalTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalTime visitTime) {
        this.visitTime = visitTime;
    }

    public Zone getVisitZone() {
        return visitZone;
    }

    public void setVisitZone(Zone visitZone) {
        this.visitZone = visitZone;
    }
    public void generateRandomVisit (Subscription subscription) {
        this.visitDate = LocalDate.now();
        this.visitTime = LocalTime.now();


    }
}
