package com.quran.quran_hizb_revision_app.not_related_tests.codingGames;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import org.junit.jupiter.api.Test;

public class BitCounting {

/*
0-separte each number to an element in a list
1-Iterate
2-transform to binary
3-count number of ones
https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java
  */

  public int countBits(int n) {

    return n;
  }

  @Test
  public void automation1() throws AWTException {
    Robot robot = new Robot();
    for (int i = 0; i < 40; i++) {
      robot.mouseMove(4, 432);
      System.out.println("passed through " + i + " Times");
      robot.delay(5000);

    }
  }

  @Test
  public void test1() {
    int x1 = 0;
    assertEquals(0, countBits(0));
  }

}
