package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.access.Access;
import ru.victoria.cw.cw1.access.Time;

import java.time.LocalTime;

public class Access {

    public static boolean isAccsess(Subscription subscription, Visit visit) {
        if (Date.isCorrectDate(subscription, visit) && Time.isCorrectTime(subscription, visit)
                && Zone.isCorrectZone(subscription, visit)) {
            return true;
        } else {
            return false;
        }
    }
}
