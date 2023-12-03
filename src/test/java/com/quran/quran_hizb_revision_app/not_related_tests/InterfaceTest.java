package com.quran.quran_hizb_revision_app.not_related_tests;

import org.junit.jupiter.api.Test;

public class InterfaceTest {

  @Test
  public void te1() {
    MyClass class1 = new MyClass();
    class1.print();
  }

}


interface Interface1 {

  public default void print() {
    System.out.println("Interface 1");
  }
}

interface Interface2 {

  public default void print() {
    System.out.println("Interface 2");
  }
}

class MyClass implements Interface1, Interface2 {

  @Override
  public void print() {
    Interface1.super.print();
    Interface2.super.print();
    System.out.println("Low");
  }
}