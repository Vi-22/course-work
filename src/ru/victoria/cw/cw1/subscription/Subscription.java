package ru.victoria.cw.cw1.subscription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Subscription {
    private SubscriptionType type;
    private LocalDate registrationDate;
    private LocalDate expirationDate;
    private Owner owner;

    public Subscription(SubscriptionType type, LocalDate registrationDate, LocalDate expirationDate, Owner owner) {
        this.setType(type);
        this.setRegistrationDate(registrationDate);
        this.setExpirationDate(expirationDate);
        this.setOwner(owner);
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        if (type == null) {
            throw new IllegalArgumentException("Необходимо задать type aбонемента");
        }
        this.type = type;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (registrationDate == null) {
            throw new IllegalArgumentException("Необходимо задать registrationDate aбонемента");
        }
        this.registrationDate = registrationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("expirationDate aбонемента не может быть null");
        }
        this.expirationDate = expirationDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        if (expirationDate == null) {
            throw new IllegalArgumentException("Owner aбонемента не может быть null");
        }
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Абонемент: " + type +
                ", с " + registrationDate.format(DateTimeFormatter.ofPattern("dd.MM.yy")) +
                " по " + expirationDate.format(DateTimeFormatter.ofPattern("dd.MM.yy")) +
                ", " + owner;
    }
}