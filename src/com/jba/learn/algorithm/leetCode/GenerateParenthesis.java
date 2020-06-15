package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  public static List<String> generateParenthesis(int n) {
    List<String> combinations = new ArrayList<>();
    //暴力法
    //generateAll(new char[2 * n], 0, combinations);
    //回朔法
    backtrack(new StringBuilder(), 0, 0, n, combinations);
    return combinations;
  }

  private static void backtrack(StringBuilder current, int start, int end, int max, List<String> combinations) {
    if (current.length() == max * 2) {
      combinations.add(current.toString());
      return;
    }
    if (start < max) {
      current.append("(");
      backtrack(current, start + 1, end, max, combinations);
    }
    if (end < start) {
      current.append(")");
      backtrack(current, start, end + 1, max, combinations);
    }
  }

  private static void generateAll(char[] current, int pos, List<String> results) {
    if (pos == current.length) {
      if (valid(current)) {
        String str = new String(current);
        results.add(str);
      }
      return;
    }
    current[pos] = '(';
    generateAll(current, pos + 1, results);
    current[pos] = ')';
    generateAll(current, pos + 1, results);
  }

  private static boolean valid(char[] current) {
    int balance = 0;
    for (char c : current) {
      if (c == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return balance == 0;
  }

  public static void main(String[] args) {
    System.out.println(generateParenthesis(1));
  }

}
