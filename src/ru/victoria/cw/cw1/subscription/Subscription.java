package ru.victoria.cw.cw1.subscription;

import java.time.LocalDate;

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
  this.type = type;
 }

 public LocalDate getRegistrationDate() {
  return registrationDate;
 }

 public void setRegistrationDate(LocalDate startDate) {
  this.registrationDate = startDate;
 }

 public LocalDate getExpirationDate() {
  return expirationDate;
 }

 public void setExpirationDate(LocalDate endDate) {
  this.expirationDate = endDate;
 }

 public Owner getOwner() {
  return owner;
 }

 public void setOwner(Owner owner) {
  this.owner = owner;
 }

 @Override
 public String toString() {
  return "Абонемент: " + type +
          ", с " + registrationDate +
          ", по " + expirationDate +
          ", " + owner;
 }
}