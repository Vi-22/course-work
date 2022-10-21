package ru.victoria.cw.cw1;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.fitness.Fitness;
import ru.victoria.cw.cw1.generator.Generator;
import ru.victoria.cw.cw1.subscription.Subscription;

public class Application {
    public static void main(String[] args6) {
        Subscription[] gymSubscriptions = new Subscription[20];
        Subscription[] poolSubscriptions = new Subscription[20];
        Subscription[] groupLessonsSubscriptions = new Subscription[20];
        Fitness fitness = new Fitness(gymSubscriptions,poolSubscriptions,groupLessonsSubscriptions);
        Subscription[] subscriptions = new Subscription[(int)(50+Math.random()*10000)];
        for (int i = 0; i < subscriptions.length;i++) {
            subscriptions[i] = Generator.generateSubscription();
            System.out.println(subscriptions[i]);
            Visit visit = Generator.generateRandomVisit();
            System.out.println(visit);
            fitness.setExitToFitness(subscriptions[i],visit);
        }
        fitness.printToList();
        fitness.fitnessCloused();
        fitness.printToList();
    }
}

