package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Zone {
    private boolean isGym;
    private boolean isPool;
    private boolean isGroupLessons;
    public Zone(boolean  isGym, boolean isPool, boolean isGroupLessons) {}

    public boolean getIsGym() {
        return isGym;
    }

    public void setGym(boolean isGym) {
        this.isGym = isGym;
    }

    public boolean getIsPool() {
        return isPool;
    }

    public void setPool(boolean isPool) {
        this.isPool = isPool;
    }

    public boolean getIsGroupLessons() {
        return isGroupLessons;
    }

    public void setGroupLessons(boolean isGroupLessons) {
        this.isGroupLessons = isGroupLessons;
    }
    public static boolean isCorrectZone(Subscription subscription, Visit visit) {
        if (visit.getVisitZone().getIsGym()) {
            if (subscription.getType().getZone().getIsGym()) {
                System.out.println(subscription.getOwner() + " зашёл в тренажерный зал");
                return true;
            } else {
                System.out.println(subscription.getOwner() + " не может посетить тренажерный зал. " +
                        "Абонемент не включает эту зону");
                return false;
            }
        } else if (visit.getVisitZone().getIsPool()) {
            if (subscription.getType().getZone().getIsPool()) {
                System.out.println(subscription.getOwner() + " зашёл в бассейн");
                return true;
            } else {
                System.out.println(subscription.getOwner() + " не может посетить бассейн. " +
                        "Абонемент не включает эту зону");
                return false;
            }
        } else {
            if (subscription.getType().getZone().getIsGroupLessons()) {
                System.out.println(subscription.getOwner() + " пришел на групповое занятие");
                return true;
            } else {
                System.out.println(subscription.getOwner() + " не может посетить бассейн. " +
                        "Абонемент не включает эту зону");
                return false;
            }
        }
    }
}
