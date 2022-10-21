package ru.victoria.cw.cw1.fitness;

import ru.victoria.cw.cw1.subscription.Zone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exit {
    private LocalDate visitDate;
    private LocalTime visitTime;
    private Zone visitZone;

    public Exit(LocalDate visitDate, LocalTime visitTime, Zone visitZone){
        this.setVisitDate(visitDate);
        this.setVisitTime(visitTime);
        this.setVisitZone(visitZone);
    }
    public Exit(){}
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


    @Override
    public String toString() {
        return
                visitDate.format(DateTimeFormatter.ofPattern("dd.MM.yy")) +
                " в " + visitTime.format(DateTimeFormatter.ofPattern("HH:mm")) +
                ": вход в " + visitZone;
    }
}
