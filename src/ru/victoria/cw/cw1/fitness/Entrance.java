package ru.victoria.cw.cw1.fitness;

import ru.victoria.cw.cw1.subscription.VisitZone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Entrance {
    private LocalDate visitDate;
    private LocalTime visitTime;
    private VisitZone visitZone;

    public Entrance(LocalDate visitDate, LocalTime visitTime, VisitZone visitZone) {
        this.setVisitDate(visitDate);
        this.setVisitTime(visitTime);
        this.setVisitZone(visitZone);
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        if (visitDate==null) {
            throw new IllegalArgumentException("Не задана дата визита");
        }
        this.visitDate = visitDate;
    }

    public LocalTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalTime visitTime) {
        if (visitTime==null) {
            throw new IllegalArgumentException("Не задано время визита");
        }
        this.visitTime = visitTime;
    }

    public VisitZone getVisitZone() {
        return visitZone;
    }

    public void setVisitZone(VisitZone visitZone) {
        if (visitZone==null||!(visitZone.getIsGym()||visitZone.getIsPool()||visitZone.getIsGroupLessons())) {
            throw new IllegalArgumentException("Не задана зона визита");
        }
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
