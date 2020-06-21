package com.jba.learn.algorithm.leetCode;

import java.util.Stack;

/**
 * 有效的括号
 * <pre>
 *
 * <pre/>
 */
public class IsValidBrackets {

  public boolean isValid(String s) {
    if (s == null) {
      return false;
    }
    if (s.trim().equals("")) {
      return true;
    }
    char[] chars = s.toCharArray();
    int length = s.length();
    if (length % 2 != 0) {
      return false;
    }
    Stack<Character> prefixs = new Stack<>();
    for (int i = 0; i < length; i++) {
      if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
        prefixs.push(chars[i]);
        continue;
      }
      if (prefixs.isEmpty()) {
        return false;
      }
      char prefix = prefixs.pop().charValue();
      if (prefix == '(' && chars[i] != ')') {
        return false;
      }
      if (prefix == '{' && chars[i] != '}') {
        return false;
      }
      if (prefix == '[' && chars[i] != ']') {
        return false;
      }
    }
    return prefixs.isEmpty();
  }

  public static void main(String[] args) {
    IsValidBrackets isValidBrackets = new IsValidBrackets();
    System.out.println(isValidBrackets.isValid("}{"));
  }

}
