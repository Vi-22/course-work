package ru.victoria.cw.cw1.access;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.fitness.Fitness;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Place {
    static Fitness fitness;
    public Place (Fitness fitness) {
        this.fitness=fitness;
    }
    public static boolean isPlacesInGym() {
        for (Subscription subscription : fitness.getGymSubscriptions()) {
            if (subscription == null) {
                return true;
            }
        }
        System.out.println("Пока вы не можете зайти. В тренажерном зале нет мест");
        return false;
    }
    public static boolean isPlacesInPool() {
        for (Subscription subscription : fitness.getGymSubscriptions()) {
            if (subscription == null) {
                return true;
            }
        }
        System.out.println("Пока вы не можете зайти. В бассейне зале нет мест");
        return false;
    }
    public static boolean isPlacesInGroupLessons() {
        for (Subscription subscription : fitness.getGroupLessonsSubscriptions()) {
            if (subscription == null) {
                return true;
            }
        }
        System.out.println("Пока вы не можете зайти. В бассейне зале нет мест");
        return false;
    }
    public static boolean isEnoughPlaces(Visit visit) {
        if (visit.getVisitZone().getIsGym()&&isPlacesInGym()) {
            return true;
        } else if (visit.getVisitZone().getIsPool()&&isPlacesInPool()) {
            return true;
        } else if (visit.getVisitZone().getIsGroupLessons()&&isPlacesInGroupLessons()) {
            return true;
        }
        else {
            return false;
        }
    }
}
