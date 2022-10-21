package ru.victoria.cw.cw1.subscription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Owner {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Owner(String firstName, String lastName, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    @Override
    public String toString() {
        return "Владелец: " + firstName + " "
                + lastName + ", "
                + birthday.format(DateTimeFormatter.ofPattern("dd:MM:yy"));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Необходимо задать значение для firstName");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (firstName == null) {
            throw new IllegalArgumentException("Необходимо задать значение для lastName");
        }
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("Необходимо задать значение для birthday");
        }
        this.birthday = birthday;
    }


}


