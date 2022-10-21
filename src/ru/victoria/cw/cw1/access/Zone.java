package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Zone {
    private boolean isGym;
    private boolean isPool;
    private boolean isGroupLessons;
    public Zone(boolean  isGym, boolean isPool, boolean isGroupLessons) {
        this.setGym(isGym);
        this.setPool(isPool);
        this.setGroupLessons(isGroupLessons);
    }

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
                return true;
            } else {
                System.out.println(subscription.getOwner() + "Ваш абонемент не включает эту зону");
                return false;
            }
        } else if (visit.getVisitZone().getIsPool()) {
            if (subscription.getType().getZone().getIsPool()) {
                return true;
            } else {
                System.out.println(subscription.getOwner() + "Ваш абонемент не включает эту зону");
                return false;
            }
        } else {
            if (subscription.getType().getZone().getIsGroupLessons()) {
                return true;
            } else {
                System.out.println(subscription.getOwner() + "Ваш абонемент не включает эту зону");
                return false;
            }
        }
    }
    public String getTrueZoneName() {
        if (isGym&&isPool&&isGroupLessons)
            return "тренажeрный зал, бассейн и зал групповых тренировок";
        else if (isGym&&isPool)
            return "тренажерный зал и бассейн";
        else if (isGym&&isGroupLessons)
            return "тренажерный зал и зал групповых тренировок";
        else if (isPool&&isGroupLessons)
            return "бассейн и зал групповых тренировок";
        else if (isGym) {
             return "тренажерный зал";
         }
        else if (isPool) {
             return "бассейн";
         }
        else if (isGroupLessons) {
             return "зал групповых тренировок";
         }
         return "зона отсутствует";
    }


    @Override
    public String toString() {
        return getTrueZoneName();
    }
}
