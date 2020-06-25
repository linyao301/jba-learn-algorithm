package com.jba.learn.algorithm.leetCode;

import java.util.Stack;

/**
 * 有效的括号
 * <pre>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
