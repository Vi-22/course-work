package ru.victoria.cw.cw1.fitness;

import ru.victoria.cw.cw1.subscription.Subscription;

import java.util.Arrays;

public class Fitness {
    private Subscription[] gymSubscriptions;
    private Subscription[] poolSubscriptions;
    private Subscription[] groupLessonsSubscriptions;

    public Fitness(Subscription[] gymSubscriptions, Subscription[] poolSubscriptions, Subscription[] groupLessonsSubscriptions) {
        this.setGymSubscriptions(gymSubscriptions);
        this.setPoolSubscriptions(poolSubscriptions);
        this.setGroupLessonsSubscriptions(groupLessonsSubscriptions);
    }

    public Subscription[] getGymSubscriptions() {
        return gymSubscriptions;
    }

    public void setGymSubscriptions(Subscription[] gymSubscriptions) {
        if (gymSubscriptions == null) {
            throw new IllegalArgumentException("gymSubscriptions не может быть null");
        }
        this.gymSubscriptions = gymSubscriptions;
    }

    public Subscription[] getPoolSubscriptions() {
        return poolSubscriptions;
    }

    public void setPoolSubscriptions(Subscription[] poolSubscriptions) {
        if (poolSubscriptions == null) {
            throw new IllegalArgumentException("poolSubscriptions не может быть null");
        }
        this.poolSubscriptions = poolSubscriptions;
    }

    public Subscription[] getGroupLessonsSubscriptions() {
        return groupLessonsSubscriptions;
    }

    public void setGroupLessonsSubscriptions(Subscription[] groupLessonsSubscriptions) {
        if (groupLessonsSubscriptions == null) {
            throw new IllegalArgumentException("groupLessonsSubscriptions не может быть null");
        }
        this.groupLessonsSubscriptions = groupLessonsSubscriptions;
    }

    private int foundFreePlaceForRecord(Subscription[] subscriptions) {
        int i = 0;
        while (subscriptions[i] != null && i < subscriptions.length - 1) {
            i++;
        }
        return i;
    }

    private boolean isEnoughPlaces(Entrance visit) {
        if (visit.getVisitZone().getIsGym() && isPlacesInGym()) {
            return true;
        } else if (visit.getVisitZone().getIsPool() && isPlacesInPool()) {
            return true;
        } else if (visit.getVisitZone().getIsGroupLessons() && isPlacesInGroupLessons()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPlacesInGym() {
        for (Subscription subscription : gymSubscriptions) {
            if (subscription == null) {
                return true;
            }
        }
        System.out.println("Пока вы не можете зайти. В тренажерном зале нет мест");
        return false;
    }

    private boolean isPlacesInPool() {
        for (Subscription subscription : poolSubscriptions) {
            if (subscription == null) {
                return true;
            }
        }
        System.out.println("Пока вы не можете зайти. В бассейне нет мест");
        return false;
    }

    private boolean isPlacesInGroupLessons() {
        for (Subscription subscription : groupLessonsSubscriptions) {
            if (subscription == null) {
                return true;
            }
        }
        System.out.println("Пока вы не можете зайти. В зале групповых тренировок нет мест");
        return false;
    }

    private boolean isCorrectDate(Subscription subscription, Entrance visit) {
        if (subscription.getRegistrationDate().isBefore(visit.getVisitDate())) {
            if (subscription.getExpirationDate().isAfter(visit.getVisitDate())) {
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

    private boolean isCorrectZone(Subscription subscription, Entrance visit) {
        if (visit.getVisitZone().getIsGym()) {
            if (subscription.getType().getZone().getIsGym()) {
                return true;
            } else {
                System.out.println("Ваш абонемент не включает тренажерный зал");
                return false;
            }
        } else if (visit.getVisitZone().getIsPool()) {
            if (subscription.getType().getZone().getIsPool()) {
                return true;
            } else {
                System.out.println("Ваш абонемент не включает бассейн");
                return false;
            }
        } else {
            if (subscription.getType().getZone().getIsGroupLessons()) {
                return true;
            } else {
                System.out.println("Ваш абонемент не включает групповые занятия");
                return false;
            }
        }
    }

    private boolean isCorrectTime(Subscription subscription, Entrance visit) {
        if (subscription.getType().getTime().getFromTime().isBefore(visit.getVisitTime())) {
            if (subscription.getType().getTime().getToTime().isAfter(visit.getVisitTime())) {
                return true;
            } else {
                System.out.println("Сейчас слишком поздно для визита");
                return false;
            }
        } else {
            System.out.println("Сейчас слишком рано для визита");
            return false;
        }
    }

    private boolean isAccess(Subscription subscription, Entrance visit) {
        if (isCorrectDate(subscription, visit) && isCorrectTime(subscription, visit)
                && isCorrectZone(subscription, visit) && isEnoughPlaces(visit)) {
            System.out.println("Вы успешно вошли");
            return true;
        } else {
            return false;
        }
    }

    public void setExitToFitness(Subscription subscription, Entrance visit) {
        if (isAccess(subscription, visit)) {
            if (visit.getVisitZone().getIsGym()) {
                this.gymSubscriptions[foundFreePlaceForRecord(gymSubscriptions)] = subscription;
            } else if (visit.getVisitZone().getIsPool()) {
                this.poolSubscriptions[foundFreePlaceForRecord(poolSubscriptions)] = subscription;
            } else {
                this.groupLessonsSubscriptions[foundFreePlaceForRecord(groupLessonsSubscriptions)] = subscription;
            }
        }
    }

    public void fitnessClosed() {
        for (int i = 0; i < this.gymSubscriptions.length; i++) {
            this.gymSubscriptions[i] = null;
            this.poolSubscriptions[i] = null;
            this.groupLessonsSubscriptions[i] = null;
        }
    }
    public void printToList() {
        System.out.println("Тренажерный зал:");
        for (int i = 0; i < this.gymSubscriptions.length; i++) {
            if (Fitness.this.gymSubscriptions[i] == null) {
                System.out.println("свободное место");
            } else {
                System.out.println(this.gymSubscriptions[i]);
            }
        }
        System.out.println("Бассейн:");
        for (int i = 0; i < poolSubscriptions.length; i++) {
            if (this.poolSubscriptions[i] == null) {
                System.out.println("свободное место");
            } else {
                System.out.println(this.poolSubscriptions[i]);
            }
        }
        System.out.println("Зал групповых тренировок:");
        for (int i = 0; i < groupLessonsSubscriptions.length; i++) {
            if (this.groupLessonsSubscriptions[i] == null) {
                System.out.println("свободное место");
            } else {
                System.out.println(this.groupLessonsSubscriptions[i]);
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