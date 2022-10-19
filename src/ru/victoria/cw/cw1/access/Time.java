package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.Type;

import java.time.LocalTime;

public class Time {
    private LocalTime fromTime;
    private LocalTime toTime;
    public Time(LocalTime fromTime, LocalTime toTime) {
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
    public static boolean isCorrectTime(Subscription subscription, Visit visit) {
        if (subscription.getType().getTime().getFromTime().isBefore(visit.getVisitTime())) {
            if (subscription.getType().getTime().getToTime().isAfter(visit.getVisitTime())) {
                return true;
            } else {
                System.out.println(subscription.getOwner() + " не может попасть в фитнес-центр. Сейчас слишком поздно для визита");
                return false;
            }
        } else {
            System.out.println(subscription.getOwner() + " не может попасть в фитнес-центр. Сейчас слишком рано для визита");
            return false;
        }
    }
}

