package com.quran.quran_hizb_revision_app.not_related_tests;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestList {


  @Test
  public void testListWithoutDefiningType() {
    List list1 = new ArrayList();
    list1.add("yes");
    list1.add(1);
    Car car1 = new Car();
    list1.add(car1);
    for (int i = 0; i < list1.size(); i++) {
      System.out.println(list1.get(i));
    }
  }

}

class Car {

  private int number;

}
