package com.quran.quran_hizb_revision_app.not_related_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class StringTest {

  @Test
  void substringMethod() {
    String strawberries = "strawberries";
    strawberries = strawberries.substring(0, 2);
    assertEquals("st", strawberries);
  }


  @Test
  void bitWiseComparator_using_OR() {
    int i1 = 1, i2 = 2;
    //i1= 01  ;i2= 10   Binary
    //3= 11   Binary
    // so 01 | 10  will give 11 which is equal to 3
    assertEquals(true, (i1 | i2) == 3);
  }

  @Test
  void bitWiseComparator_using_AND() {
    int i1 = 1, i2 = 2;
    //i1= 01  ;i2= 10   Binary
    //3= 11   Binary
    // so 01 | 10  will give 11 which is equal to 3
    assertEquals(true, (i1 & i2) == 0);
  }


  @Test
  void findSize() {
    int array[] = {1, 2, 3, 4};
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }
  }

  @Test
  void StringTrim() {
    String str = "abcde";
    str = str.trim();
    str.toUpperCase();
    str.substring(3, 4);
    System.out.println(str);
  }


  @Test
  void testSubClass() {
    SubClass subClass1 = new SubClass();
    subClass1.print();
  }
}

class SuperClass {

  void print() {
    System.out.print("SuperClass");
  }
}

class SubClass extends SuperClass {

  @Override
  void print() {
    super.print();
    System.out.print("+SubClass");
  }
}