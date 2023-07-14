package com.quran.quran_hizb_revision_app.Others;

import java.util.ArrayList;
import java.util.List;

public class Randomness {

  public static void main(String[] args) {
//TODO: add the case of don't call 2 times a day and wait some more
    //TODO: if return is nothing then call again
    //Switch if Urgency Exist or Not
    boolean boolUrgency = true;

    List<String> allList = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      if (boolUrgency) {
        allList.add(randomUrgency());
      } else {
        allList.add(randomWithoutUrgency());
      }

    }

    long totalBad = allList.stream().filter(r -> "Bad".equals(r)).count();
    long totalAverage = allList.stream().filter(r -> "Average".equals(r)).count();
    long totalGood = allList.stream().filter(r -> "Good".equals(r)).count();
    long totalMastery = allList.stream().filter(r -> "Mastery".equals(r)).count();
    long totalNothing = allList.stream().filter(r -> "nothing".equals(r)).count();
    long totalUrgency = allList.stream().filter(r -> "Urgency".equals(r)).count();

    if (boolUrgency) {
      System.out.println("Number of 45% Urgency is: " + totalUrgency);
      System.out.println("Number of 25% Bad is: " + totalBad);
      System.out.println("Number of 15% Average is: " + totalAverage);
      System.out.println("Number of 10% Good is: " + totalGood);
      System.out.println("Number of 5% Mastery is: " + totalMastery);
      System.out.println("Number of 'Nothing' is: " + totalNothing);
    } else {
      System.out.println("Number of 45% Bad is: " + totalBad);
      System.out.println("Number of 25% Average is: " + totalAverage);
      System.out.println("Number of 20% Good is: " + totalGood);
      System.out.println("Number of 10% Mastery is: " + totalMastery);
      System.out.println("Number of 'Nothing' is: " + totalNothing);
    }


  }


  public static String randomUrgency() {
    boolean boolBad = true;
    boolean boolAverage = false;
    boolean boolGood = true;
    boolean boolMastery = true;

    var d = Math.random();

    //Urgency 45%
    if (d < 0.45) {
      return "Urgency";
    }
    //  Bad 25%
    else if (d < 0.70) {
      if (boolBad) {
        return "Bad";
      } else {
        return "nothing";
      }
    } // Average 15%
    else if (d < 0.85) {
      if (boolAverage) {
        return "Average";
      } else {
        return "nothing";
      }
    } // Good 10%
    else if (d < 0.95) {
      if (boolGood) {
        return "Good";
      }
      return "nothing";
    } // Mastery 5%
    else {
      if (boolMastery) {
        return "Mastery";
      } else {
        return "nothing";
      }
    }
  }


  public static String randomWithoutUrgency() {
    boolean boolBad = true;
    boolean boolAverage = false;
    boolean boolGood = true;
    boolean boolMastery = true;
    boolean boolUrgency = true;

    var d = Math.random();
    //  Bad 45%
    if (d < 0.45) {
      if (boolBad) {
        return "Bad";
      } else {
        return "nothing";
      }
    } // Average 25%
    else if (d < 0.70) {
      if (boolAverage) {
        return "Average";
      } else {
        return "nothing";
      }
    } // Good 20%
    else if (d < 0.90) {
      if (boolGood) {
        return "Good";
      }
      return "nothing";
    } // Mastery 10%
    else {
      if (boolMastery) {
        return "Mastery";
      } else {
        return "nothing";
      }
    }
  }


}

//TODO: add an sql function that will (string User) and use this script to just set the value of the variable ${}
// nad apply it with each user added and to delete a User, use the java Delete post (Get all the list by name, then delete and save User)


