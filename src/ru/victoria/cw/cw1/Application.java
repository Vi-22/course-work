package ru.victoria.cw.cw1;

import ru.victoria.cw.cw1.fitness.Exit;
import ru.victoria.cw.cw1.fitness.Fitness;
import ru.victoria.cw.cw1.generator.Generator;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.SubscriptionType;

public class Application {
    public static void main(String[] args6) {
        Subscription[] gymSubscriptions = new Subscription[20];
        Subscription[] poolSubscriptions = new Subscription[20];
        Subscription[] groupLessonsSubscriptions = new Subscription[20];
        Fitness fitness = new Fitness(gymSubscriptions, poolSubscriptions, groupLessonsSubscriptions);
        Subscription[] clientSubscriptions = new Subscription[(int) (50 + Math.random() * 300)];
        for (int i = 0; i < clientSubscriptions.length; i++) {
            clientSubscriptions[i] = Generator.generateSubscription();
            System.out.println(clientSubscriptions[i]);
            Exit visit = Generator.generateRandomExit();
            System.out.println(visit);
            fitness.setExitToFitness(clientSubscriptions[i], visit);
        }
        fitness.printToList();
        fitness.fitnessCloused();
        fitness.printToList();
    }
}

