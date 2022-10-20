package ru.victoria.cw.cw1.actions;

import ru.victoria.cw.cw1.access.Time;
import ru.victoria.cw.cw1.access.Zone;
import ru.victoria.cw.cw1.subscription.Subscription;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Visit {
    private LocalDate visitDate;
    private LocalTime visitTime;
    private Zone visitZone;

    public Visit(LocalDate visitDate,LocalTime visitTime, Zone visitZone){
        this.setVisitDate(visitDate);
        this.setVisitTime(visitTime);
        this.setVisitZone(visitZone);
    }
    public Visit(){}
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
        this.visitZone = randomZone();

    }
    public Zone randomZone(){
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return new Zone(true, false, false);
        }
        else if (random == 1) {
            return new Zone(false, true,false);
        } else {
            return new Zone(false, false,true);
        }
    }

    @Override
    public String toString() {
        return
                visitDate.format(DateTimeFormatter.ofPattern("dd.MM.yy")) +
                " в " + visitTime.format(DateTimeFormatter.ofPattern("HH:mm")) +
                ": вход в " + visitZone;
    }
}
