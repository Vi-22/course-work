package ru.victoria.cw.cw1.fitness;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.access.Access;

import java.util.Arrays;

public class Fitness {
    private static Subscription gymSubscriptions[] = new Subscription[20];
    private static Subscription poolSubscriptions[] = new Subscription[20];
    private static Subscription groupLessonsSubscriptions[] = new Subscription[20];

    public Fitness(Subscription[] gymSubscriptions, Subscription[] poolSubscriptions, Subscription[] groupLessonsSubscriptions) {
        this.setGymSubscriptions(gymSubscriptions);
        this.setPoolSubscriptions(poolSubscriptions);
        this.setGroupLessonsSubscriptions(groupLessonsSubscriptions);
    }

    public Subscription[] getGymSubscriptions() {
        return gymSubscriptions;
    }

    public void setGymSubscriptions(Subscription[] gymSubscriptions) {
        Fitness.gymSubscriptions=gymSubscriptions;
    }

    public Subscription[] getPoolSubscriptions() {
        return poolSubscriptions;
    }

    public void setPoolSubscriptions(Subscription[] poolSubscriptions) {
        Fitness.poolSubscriptions = poolSubscriptions;
    }

    public Subscription[] getGroupLessonsSubscriptions() {
        return groupLessonsSubscriptions;
    }

    public void setGroupLessonsSubscriptions(Subscription[] groupLessonsSubscriptions) {
        Fitness.groupLessonsSubscriptions = groupLessonsSubscriptions;
    }

    public static int foundNullElementInArray(Subscription[] subscriptions) {
        int i = 0;
        while (subscriptions[i]!=null&&i<subscriptions.length-1) {
            i++;
        }
        return i;
    }

    public static boolean setExitToNeededArea(Subscription subscription, Visit visit) {
        if (Access.isAccess(subscription, visit)) {
            if (visit.getVisitZone().getIsGym()) {
                Fitness.gymSubscriptions[foundNullElementInArray(gymSubscriptions)] = subscription;
            } else if (visit.getVisitZone().getIsPool()) {
                Fitness.poolSubscriptions[foundNullElementInArray(poolSubscriptions)] = subscription;
            } else {
                Fitness.groupLessonsSubscriptions[foundNullElementInArray(groupLessonsSubscriptions)] = subscription;
                return true;
            }
        }
        return false;
    }
    public static void cloused() {
        for (int i = 0; i < gymSubscriptions.length; i++) {
            Fitness.gymSubscriptions[i] = null;
            Fitness.poolSubscriptions[i] = null;
            Fitness.groupLessonsSubscriptions[i] = null;
        }
    }

    public static void printToList() {
        System.out.println("Тренажерный зал:");
        for (int i = 0; i < gymSubscriptions.length; i++) {
            if (Fitness.gymSubscriptions[i]==null) {
                System.out.println("свободное место");
            } else {
                System.out.println(Fitness.gymSubscriptions[i]);
            }
        }
        System.out.println("Бассейн:");
        for (int i = 0; i < poolSubscriptions.length; i++) {
            if (Fitness.poolSubscriptions[i] == null) {
                System.out.println("свободное место");
            } else {
                System.out.println(Fitness.poolSubscriptions[i]);
            }
        }
        System.out.println("Зал групповых тренировок: ");
        for (int i = 0; i < groupLessonsSubscriptions.length; i++) {
            if (Fitness.gymSubscriptions[i]==null) {
                System.out.println("свободное место");
            } else {
                System.out.println(Fitness.groupLessonsSubscriptions[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "Тренажерный зал:" + "\n"
                + Arrays.toString(getGymSubscriptions()) + "\n"
                + "Бассейн:" + "\n"
                + Arrays.toString(getPoolSubscriptions()) + "\n"
                + "Зал групповых тренировок:" + "\n"
                + Arrays.toString(getGroupLessonsSubscriptions());
    }
}