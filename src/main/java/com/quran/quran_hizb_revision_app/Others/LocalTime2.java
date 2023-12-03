package com.quran.quran_hizb_revision_app.Others;

import com.quran.quran_hizb_revision_app.Entities.MasteryEnum;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTime2 {

  public static void main(String[] args) {

    ZoneId z = ZoneId.of("Europe/Paris");
    LocalDate localDate = LocalDate.now(z);  // Always pass a time zone.

    LocalDateTime localDateTime = LocalDateTime.now();
    LocalTime localTime = LocalTime.parse("01:20");

    Instant rightNow = Instant.now();

    System.out.println(rightNow);
    System.out.println(localDate);
    System.out.println(localDateTime);
    System.out.println(LocalTime.now());
    System.out.println(LocalDateTime.now().minusDays(1));
    System.out.println(LocalDateTime.now().toLocalDate().atStartOfDay());

    String toTestEnum = "Average";
    boolean enumContainsString = false;

    for (MasteryEnum e : MasteryEnum.values()) {
      if (e.name().equals(toTestEnum)) {
        enumContainsString = true;
      }
      System.out.println(e);
    }

    System.out.println(enumContainsString);
  }
}

//TODO: add an sql function that will (string User) and use this script to just set the value of the variable ${}
// nad apply it with each user added and to delete a User, use the java Delete post (Get all the list by name, then delete and save User)


