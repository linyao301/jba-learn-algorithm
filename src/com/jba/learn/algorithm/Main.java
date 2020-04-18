package com.jba.learn.algorithm;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    float a = 0.1f;
    float b = 0.2f;
    System.out.println(a + b);
    System.out.println(new BigDecimal(a + b));
    System.out.println((a + b) == 0.3);
  }
}
