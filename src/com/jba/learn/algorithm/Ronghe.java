package com.jba.learn.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Ronghe {

  public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    scanner.nextInt();
    System.out.println(calc(6, new int[]{3, 7, 10, 11, 12, 0}));
  }

  private static int calc(int n, int[] data) {
    if (n == 0 || n == 1) {
      return n;
    }
    if (n == 2) {
      return Math.max(data[0], data[1]);
    }
    int result = fill(data[0], data[1], data[2]);
    int i = 3;
    while (i < n) {
      if (i + 1 == n) {
        result = Math.max(result, data[i]);
        break;
      }
      result = fill(result, data[i], data[i + 1]);
      i += 2;
    }
    return result;
  }

  private static int fill(int x, int y, int z) {
    if (x == y && y == z) {
      return 0;
    } else if (x == y) {
      return Math.abs(z - y);
    } else if (y == z) {
      return Math.abs(y - x);
    } else {
      return Math.abs(2 * y - x - z);
    }
  }

}
