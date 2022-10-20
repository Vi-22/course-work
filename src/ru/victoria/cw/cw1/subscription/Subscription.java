package ru.victoria.cw.cw1.subscription;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Subscription {
 private Type type;
 private LocalDate startDate;
 private LocalDate endDate;
 private Owner owner;

 public Subscription(Type type, LocalDate startDate, LocalDate endDate, Owner owner) {
 }

 public Subscription() {
 }

 public void generateSubscription() {
  Type types[] = Type.values();
  this.type = types[(int) (Math.random() * types.length)];
  this.startDate = LocalDate.of(2022, (int) (1 + Math.random() * 11),(int) (1 + Math.random() * 27));
  if (type==Type.ONE_DAY) {
      this.endDate = LocalDate.of(startDate.getYear(),
           startDate.getMonthValue(), startDate.getDayOfMonth() + 1);
  } else {
      this.endDate = LocalDate.of(startDate.getYear(),
           (int) ((Math.random()) * (11 - startDate.getMonthValue()) +
                   startDate.getMonthValue()), (int) (1 + Math.random() * 27));
  }
  this.owner = new Owner();
  this.owner.generateOwner();
 }

 public Type getType() {
  return type;
 }

 public void setType(Type type) {
  this.type = type;
 }

 public LocalDate getStartDate() {
  return startDate;
 }

 public void setStartDate(LocalDate startDate) {
  this.startDate = startDate;
 }

 public LocalDate getEndDate() {
  return endDate;
 }

 public void setEndDate(LocalDate endDate) {
  this.endDate = endDate;
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
          ", с " + startDate +
          ", по " + endDate +
          ", " + owner;
 }
}