package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Date {
    public static boolean isCorrectDate(Subscription subscription, Visit visit) {
        if (subscription.getStartDate().isBefore(visit.getVisitDate())) {
            if (subscription.getEndDate().isAfter(visit.getVisitDate())) {
                return true;
            } else {
                System.out.println("Ваш абонемент истек");
                return false;
            }
        } else {
            System.out.println("Срок действия абонемента еще не начался");
            return false;
        }
    }
}
