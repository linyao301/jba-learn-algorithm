package com.jba.learn.algorithm.leetCode;

public class Atoi {

  public static int myAtoi(String str) {
    str = str.trim();
    if ("".equals(str)) {
      return 0;
    }
    int negative = 1;
    int result = 0;
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (i == 0 && chars[i] == '-') {
        negative = -1;
        continue;
      }
      if (i == 0 && chars[i] == '+') {
        continue;
      }
      if (i <= 1 && !Character.isDigit(chars[i])) {
        return result;
      }
      if (!Character.isDigit(chars[i])) {
        break;
      }
      int digit = chars[i] - '0';
      if (negative == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7))) {
        return Integer.MAX_VALUE;
      }
      if (negative == -1 && (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && digit > 8))) {
        return Integer.MIN_VALUE;
      }
      result = result * 10 + digit;
    }
    return negative * result;
  }

  public static void main(String[] args) {
    System.out.println(myAtoi("-a"));
    System.out.println('8' - '0');
  }
}
