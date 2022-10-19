package ru.victoria.cw.cw1.subscription;

import java.time.LocalDate;

public class Owner {
    private String name;
    private String surName;
    private LocalDate birthday;


    @Override
    public String toString() {
        return "Владелец: " + name + " "
                + surName + ", "
                + birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Необходимо задать значение для name");
        }
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (name == null) {
            throw new IllegalArgumentException("Необходимо задать значение для surName");
        }
        this.surName = surName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("Необходимо задать значение для patronymic");
        }
        this.birthday = birthday;
    }

    public void newOwner() {
        String[] names = {"Федор", "Иван", "Юрий", "Тимофей", "Олег", "Валерий"};
        String[] surNames = {"Иванко", "Кот", "Кирпич", "Тренировко", "Болтайко"};
        this.name = names[(int) (Math.random() * names.length)];
        this.surName = surNames[(int) (Math.random() * surNames.length)];
        this.birthday = LocalDate.of((int) (1940 + Math.random() * 50), (int) (1+ Math.random() * 11), (int) (1+Math.random() * 27));
    }
}


