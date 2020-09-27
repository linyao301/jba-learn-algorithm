package com.jba.learn.algorithm;

public class Transfer {

  public static void main(String[] args) {
    int k = 10;
    int n = 10;
    int m = 10;
    String transfered = transfer(k, m);
    int result = 0;
    for (char num : transfered.toCharArray()) {
      if ((int) num == n) {
        result++;
      }
    }
    System.out.println(result);
  }

  private static String transfer(int k, int m) {
    StringBuilder sb = new StringBuilder();
    int num = k;
    while (num / m != 0) {
      num = num % m;
      sb.append(num);
    }
    if (num != 0) {
      sb.append(num);
    }
    return sb.toString();
  }

}
