package com.jba.learn.algorithm.leetCode;

/**
 * 整数反转
 */
public class IntReverse {

  public int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int mod = x % 10;
      if (result > 214748364 || (result == 214748364 && mod > 7)) {
        return 0;
      }
      if (result < -214748364 || (result == -214748364 && mod < -8)) {
        return 0;
      }
      result = result * 10 + mod;
      x /= 10;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(123);
    System.out.println(-123);
  }

}
