package com.jba.learn.algorithm.recursion;

/**
 * 递归
 */
public class Recursion {

  private static int fibonacci(int n) {
    if (n == 1) {
      return 1;
    }
    return n + fibonacci(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(fibonacci(n));
    System.out.println(0.5 * (n * (n + 1)));
  }

}
