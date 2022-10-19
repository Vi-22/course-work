package ru.victoria.cw.cw1;

import ru.victoria.cw.cw1.access.Access;
import ru.victoria.cw.cw1.access.Time;
import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.fitness.Fitness;
import ru.victoria.cw.cw1.subscription.Owner;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.Type;

import java.util.Arrays;

public class Application {
    public static void main(String[] args6) {
        Subscription gymSubscriptions[] = new Subscription[20];
        Subscription poolSubscriptions[] = new Subscription[20];
        Subscription groupLessonsSubscriptions[] = new Subscription[20];
        Fitness fitness = new Fitness(gymSubscriptions, poolSubscriptions, groupLessonsSubscriptions);
        Subscription[] subscriptions = new Subscription[(int)(Math.random()*100)];
        System.out.println(Arrays.toString(subscriptions));
        for (int i = 0; i < subscriptions.length; i++) {
            subscriptions[i] = new Subscription();
            subscriptions[i].generateSubscription();
            System.out.println(subscriptions[i]);
        }
        for (int i = 0, j=0; i < subscriptions.length;i++) {
            Visit visit = new Visit();
            visit.generateRandomVisit(subscriptions[i]);
            gymSubscriptions[j] = new Subscription();
            poolSubscriptions[j] = new Subscription();
            gymSubscriptions[j] = new Subscription();
            if (fitness.setSubscriptionsToNeededArea(subscriptions[i],visit,j)) {
                j++;
            }
        }
        System.out.println(Type.DAY.getTime());
    }
}

