package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Access {

    public static boolean isAccess(Subscription subscription, Visit visit) {
        if (Date.isCorrectDate(subscription, visit) && Time.isCorrectTime(subscription, visit)
                && Zone.isCorrectZone(subscription, visit)&&Place.isEnoughPlaces(visit)) {
            System.out.println("Вы успешно вошли");
            return true;
        } else {
            return false;
        }
    }
}
