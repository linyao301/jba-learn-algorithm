package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <pre>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 */
public class GenerateParenthesis {

  public static List<String> generateParenthesis(int n) {
    List<String> combinations = new ArrayList<>();
    //暴力法
    generateAll(new char[2 * n], 0, combinations);
    //回朔法
    //backtrack(new StringBuilder(), 0, 0, n, combinations);
    return combinations;
  }

  //region 回朔法
  private static void backtrack(StringBuilder current, int start, int end, int max, List<String> combinations) {
    if (current.length() == max * 2) {
      combinations.add(current.toString());
      return;
    }
    if (start < max) {
      current.append("(");
      backtrack(current, start + 1, end, max, combinations);
      current.deleteCharAt(current.length() - 1);
    }
    if (end < start) {
      current.append(")");
      backtrack(current, start, end + 1, max, combinations);
      current.deleteCharAt(current.length() - 1);
    }
  }
  //endregion

  //region 暴力法
  private static void generateAll(char[] current, int pos, List<String> results) {
    if (pos == current.length) {
      if (valid(current)) {
        results.add(new String(current));
      }
      return;
    }
    //添加左括号
    current[pos] = '(';
    generateAll(current, pos + 1, results);
    //添加右括号
    current[pos] = ')';
    generateAll(current, pos + 1, results);
  }

  private static boolean valid(char[] current) {
    int left = 0;
    int right = 0;
    for (int i = 0; i < current.length; i++) {
      if (current[i] == '(') {
        left++;
      } else {
        right++;
      }
      if (right > left) {
        return false;
      }
    }
    return (right - left) == 0;
  }
  //endregion

  public static void main(String[] args) {
    System.out.println(generateParenthesis(2));
  }

}
