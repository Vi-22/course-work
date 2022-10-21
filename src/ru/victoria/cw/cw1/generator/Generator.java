package ru.victoria.cw.cw1.generator;

import ru.victoria.cw.cw1.actions.Visit;
import ru.victoria.cw.cw1.fitness.Zone;
import ru.victoria.cw.cw1.subscription.Owner;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.Type;

import java.time.LocalDate;
import java.time.LocalTime;

public class Generator {
    public static Subscription generateSubscription() {
        Type types[] = Type.values();
        Type type = types[(int) (Math.random() * types.length)];
        LocalDate registrationDate = LocalDate.of(2022, (int) (1 + Math.random() * 11),
                (int) (1 + Math.random() * 27));
        LocalDate expirationDateOneDay = LocalDate.of(registrationDate.getYear(),
                registrationDate.getMonthValue(), registrationDate.getDayOfMonth() + 1);
        LocalDate expirationDateRandom = LocalDate.of(registrationDate.getYear(),
                (int) ((Math.random()) * (11 - registrationDate.getMonthValue()) +
                        registrationDate.getMonthValue()), (int) (1 + Math.random() * 27));
        Owner owner = generateRandomOwner();
        if (type == Type.ONE_DAY) {
            return new Subscription(type, registrationDate, expirationDateOneDay, owner);
        } else {
            return new Subscription(type, registrationDate, expirationDateRandom, owner);
        }
    }
    public static Owner generateRandomOwner() {
        String[] names = {"Федор", "Александра","Иван","Юлия","Юрий", "Тимофей", "Олег", "Валерий", "Татьяна"};
        String[] surNames = {"Иванко", "Кот", "Кирпич", "Тренировко", "Болтайко", "Шутка", "Маршрутка"};
        String firstName = names[(int) (Math.random() * names.length)];
        String lastName = surNames[(int) (Math.random() * surNames.length)];
        LocalDate birthday = LocalDate.of((int) (1940 + Math.random() * 50),
                (int) (1+ Math.random() * 11), (int) (1+Math.random() * 27));
        return new Owner(firstName,lastName, birthday);
    }
    public static Visit generateRandomVisit () {
        LocalDate visitDate = LocalDate.now();
        LocalTime visitTime = LocalTime.now();
        Zone visitZone = generateRandomZone();
        return new Visit(visitDate,visitTime,visitZone);
    }
    public static Zone generateRandomZone(){
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return new Zone(true, false, false);
        }
        else if (random == 1) {
            return new Zone(false, true,false);
        } else {
            return new Zone(false, false,true);
        }
    }
}
