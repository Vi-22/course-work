package ru.victoria.cw.cw1;

import ru.victoria.cw.cw1.access.Place;
import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.fitness.Fitness;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Application {
    public static void main(String[] args6) {
        Subscription gymSubscriptions[] = new Subscription[20];
        Subscription poolSubscriptions[] = new Subscription[20];
        Subscription groupLessonsSubscriptions[] = new Subscription[20];
        Fitness fitness = new Fitness(gymSubscriptions,poolSubscriptions,groupLessonsSubscriptions);
        Place place = new Place(fitness);
        Subscription[] subscriptions = new Subscription[(int)(50+Math.random()*10000)];
        for (int i = 0; i < subscriptions.length;i++) {
            subscriptions[i] = new Subscription();
            subscriptions[i].generateSubscription();
            System.out.println(subscriptions[i]);
            Visit visit = new Visit();
            visit.generateRandomVisit(subscriptions[i]);
            System.out.println(visit);
            Fitness.setExitToNeededArea(subscriptions[i],visit);
        }
        Fitness.printToList();
        Fitness.cloused();
        Fitness.printToList();
    }
}

