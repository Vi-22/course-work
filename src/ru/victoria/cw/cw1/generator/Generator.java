package ru.victoria.cw.cw1.generator;

import ru.victoria.cw.cw1.fitness.Entrance;
import ru.victoria.cw.cw1.subscription.VisitZone;
import ru.victoria.cw.cw1.subscription.Owner;
import ru.victoria.cw.cw1.subscription.Subscription;
import ru.victoria.cw.cw1.subscription.SubscriptionType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;

public class Generator {
    public static Subscription generateSubscription() {
        SubscriptionType[] types = SubscriptionType.values();
        SubscriptionType type = types[(int) (Math.random() * types.length)];
        LocalDate registrationDate = generateRandomRegistrationDate();
        LocalDate expirationDate = generateRandomExpirationDate(type, registrationDate);
        Owner owner = generateRandomOwner();
        return new Subscription(type, registrationDate, expirationDate, owner);
        }
    private static LocalDate generateRandomRegistrationDate() {
        int year = (int) (2000 + Math.random() * 22);
        int month = (int) (1 + Math.random() * 12);
        int day =  (int) (1 + Math.random() * (Month.of(month).maxLength()-1));
        return LocalDate.of(year,month,day);
    }
    private static LocalDate generateRandomExpirationDate(SubscriptionType type, LocalDate registrationDate) {
        int year;
        int month;
        int day;
        if (type == SubscriptionType.ONE_DAY) {
           year = registrationDate.getYear();
           month = registrationDate.getMonthValue();
           day = registrationDate.getDayOfMonth() + 1;
        } else {
            year = registrationDate.getYear() + (int) (Math.random() * 10);
            if (registrationDate.getYear()==year) {
                month = registrationDate.getMonthValue() + (int) (Math.random() * (12 - registrationDate.getMonthValue()));
            } else {
                month = (int) (Math.random() * 12) + 1;
            }
            int daysInMonth = YearMonth.of(year,month).lengthOfMonth();
            if (registrationDate.getYear()==year&&registrationDate.getMonthValue()==month) {
                day = (int) (1 + Math.random() * (daysInMonth - registrationDate.getDayOfMonth())) + registrationDate.getDayOfMonth();
            } else {
                day = (int) (1 + Math.random() * (daysInMonth));
            }
        }
        return LocalDate.of(year,month,day);
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

    public static Entrance generateRandomVisit() {
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
