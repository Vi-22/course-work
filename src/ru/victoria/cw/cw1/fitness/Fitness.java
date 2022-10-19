package ru.victoria.cw.cw1.fitness;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.Type;
import ru.victoria.cw.cw1.access.Access;

public class Fitness {
    private Subscription gymSubscriptions[] = new Subscription[20];
    private Subscription poolSubscriptions[] = new Subscription[20];
    private Subscription groupLessonsSubscriptions[] = new Subscription[20];

    public Fitness( Subscription gymSubscriptions[], Subscription poolSubscriptions[], Subscription groupLessonsSubscriptions[] ) {
    }

    public boolean setSubscriptionsToNeededArea(Subscription subscription, Visit visit, int i) {
        if (Access.isAccsess(subscription, visit)) {
            System.out.println("Тренировка началась");
            if (visit.getVisitZone().getIsGym()) {
                this.gymSubscriptions[i] = new Subscription();
                this.gymSubscriptions[i] = subscription;
            } else if (visit.getVisitZone().getIsPool()) {
                this.poolSubscriptions[i] = new Subscription();
                this.poolSubscriptions[i] = subscription;
            } else {
                this.groupLessonsSubscriptions[i] = new Subscription();
                this.groupLessonsSubscriptions[i] = subscription;
            }
            return true;
        } else {
            System.out.println("Доступ отклонен");
            return false;
        }
    }
}