package com.quran.quran_hizb_revision_app.process;

import com.quran.quran_hizb_revision_app.Entities.Revision;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomProcessImpl {

  private List<Revision> listRevision;
  private boolean boolUrgency;
  private Revision revisionChosen;
  private String revisionStringResult;


  public RandomProcessImpl() {
  }


  /**
   * Public Getter of the listRevision
   *
   * @return listRevision
   */
  public List<Revision> getListRevision() {
    return listRevision;
  }

  /**
   * Public Setter of the listRevision
   *
   * @param listRevision the listRevision to set
   */
  public void setListRevision(
      List<Revision> listRevision) {
    this.listRevision = listRevision;
  }


  public Revision getRandom(List<Revision> listRevision) {
    //set the attribute of the class, but not really needed :D

    this.listRevision = listRevision;
    this.boolUrgency = listRevision.stream().filter(r -> r.isUrgency()).findFirst().isPresent();

    chooseMethodAccordingToUrgencyAndFindRevisionStringRepeatIfFoundNothing();
    chooseTheRevisionOutofItsList();

    return this.revisionChosen;
  }

  public void chooseMethodAccordingToUrgencyAndFindRevisionStringRepeatIfFoundNothing() {
    //if didn't choose yet or found a "nothing" repeat the choice
    List<Revision> changingTypeListOfRevisions2 = new ArrayList<>();
    List<Revision> changingTypeListOfRevisionsNotLessThanADay = new ArrayList<>();
    while (
        this.revisionStringResult == null ||
            changingTypeListOfRevisions2.isEmpty()
            || this.revisionStringResult.equals("nothing")
            || changingTypeListOfRevisionsNotLessThanADay.isEmpty()
    ) {
      //Urgency
      if (this.boolUrgency) {
        this.revisionStringResult = randomUrgency();
      } else {
        //No Urgency
        this.revisionStringResult = randomWithoutUrgency();
      }
      changingTypeListOfRevisions2 = this.listRevision.stream()
          .filter(r -> r.getMastery().name().equals(this.revisionStringResult)).collect(
              Collectors.toList());

      //empty if no elements has more than day modified or null
      changingTypeListOfRevisionsNotLessThanADay = changingTypeListOfRevisions2.stream()
          .filter(
              r -> {
                if ((r.getTimeAdded() == null) || (
                    // To get the Start of the day at 00:00
                    r.getTimeAdded().isBefore(LocalDateTime.now().toLocalDate().atStartOfDay())

                    // can Also use the code below 1 day before current time
                    // r.getTimeAdded().isBefore(LocalDateTime.now().minusDays(1))
                )
                ) {
                  return true;
                } else {
                  return false;
                }
              }
          ).collect(Collectors.toList());
    }


  }

  public void chooseTheRevisionOutofItsList() {
    //get the corresponding list
    List<Revision> changingTypeListOfRevisions = this.listRevision.stream()
        .filter(r -> r.getMastery().name().equals(this.revisionStringResult))
        .filter(r -> {
          if ((r.getTimeAdded() == null) || (
              // To get the Start of the day at 00:00
              r.getTimeAdded().isBefore(LocalDateTime.now().toLocalDate().atStartOfDay())

              // can Also use the code below 1 day before current time
              // r.getTimeAdded().isBefore(LocalDateTime.now().minusDays(1))
          )
          ) {
            return true;
          } else {
            return false;
          }
        })
        .collect(
            Collectors.toList());

    //get one random element of the previous list
    if (!changingTypeListOfRevisions.isEmpty()) {
      int max = changingTypeListOfRevisions.size() - 1;
      int min = 0;

      //get random index value
      Random rand = new Random();
      int randomValueOfIndex = rand.nextInt((max - min) + 1) + min;

      this.revisionChosen = changingTypeListOfRevisions.get(randomValueOfIndex);
    }


  }


  public String randomUrgency() {
    boolean boolBad = true;
    boolean boolAverage = true;
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


  public String randomWithoutUrgency() {
    boolean boolBad = true;
    boolean boolAverage = true;
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
