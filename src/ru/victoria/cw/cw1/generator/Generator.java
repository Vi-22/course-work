package ru.victoria.cw.cw1.generator;

import ru.victoria.cw.cw1.fitness.Entrance;
import ru.victoria.cw.cw1.subscription.VisitZone;
import ru.victoria.cw.cw1.subscription.Owner;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.SubscriptionType;

import java.time.LocalDate;
import java.time.LocalTime;

public class Generator {
    public static Subscription generateSubscription() {
        SubscriptionType[] types = SubscriptionType.values();
        SubscriptionType type = types[(int) (Math.random() * types.length)];
        LocalDate registrationDate = LocalDate.of(2022, (int) (1 + Math.random() * 11),
                (int) (1 + Math.random() * 27));
        LocalDate expirationDate = generateRandomExpirationDate(type, registrationDate);
        Owner owner = generateRandomOwner();
        if (type == SubscriptionType.ONE_DAY) {
            return new Subscription(type, registrationDate, expirationDate, owner);
        } else {
            return new Subscription(type, registrationDate, expirationDate, owner);

        }
    }

    private static LocalDate generateRandomExpirationDate(SubscriptionType type, LocalDate registrationDate) {
        LocalDate expirationDateOneDay =
                LocalDate.of(registrationDate.getYear(),
                        registrationDate.getMonthValue(),
                        registrationDate.getDayOfMonth() + 1);
        LocalDate expirationDateRandom =
                LocalDate.of(registrationDate.getYear() + (int) (Math.random() * 10),
                        (((int) ((Math.random()) * (12 - registrationDate.getMonthValue()))) +
                                registrationDate.getMonthValue()),
                        (int) (1 + Math.random() * 27));
        if (type == SubscriptionType.ONE_DAY) {
            return expirationDateOneDay;
        } else {
            return expirationDateRandom;
        }
    }

    private static Owner generateRandomOwner() {
        String[] names = {"Федор", "Александра", "Иван", "Юлия", "Юрий", "Тимофей", "Олег", "Валерий", "Татьяна"};
        String[] surNames = {"Иванко", "Кот", "Кирпич", "Тренировко", "Болтайко", "Шутка", "Маршрутка"};
        String firstName = names[(int) (Math.random() * names.length)];
        String lastName = surNames[(int) (Math.random() * surNames.length)];
        LocalDate birthday = LocalDate.of((int) (1940 + Math.random() * 50),
                (int) (1 + Math.random() * 11), (int) (1 + Math.random() * 27));
        return new Owner(firstName, lastName, birthday);
    }

    public static Entrance generateRandomExit() {
        LocalDate exitDate = LocalDate.now();
        LocalTime exitTime = LocalTime.now();
        VisitZone exitZone = generateRandomZone();
        return new Entrance(exitDate, exitTime, exitZone);
    }

    public static VisitZone generateRandomZone() {
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return new VisitZone(true, false, false);
        } else if (random == 1) {
            return new VisitZone(false, true, false);
        } else {
            return new VisitZone(false, false, true);
        }
    }
}
