package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 * <pre>
 *   给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class LetterCombinations {

  HashMap<Integer, String[]> dict = new HashMap<>();
  List<String[]> matched = new ArrayList<>();
  List<String> result = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    dict.put(2, new String[]{"a", "b", "c"});
    dict.put(3, new String[]{"d", "e", "f"});
    dict.put(4, new String[]{"g", "h", "i"});
    dict.put(5, new String[]{"j", "k", "l"});
    dict.put(6, new String[]{"m", "n", "o"});
    dict.put(7, new String[]{"p", "q", "r", "s"});
    dict.put(8, new String[]{"t", "u", "v"});
    dict.put(9, new String[]{"w", "x", "y", "z"});
    if (digits == null || digits.isEmpty()) {
      return new ArrayList<>();
    }
    char[] chars = digits.toCharArray();
    for (char num : chars) {
      matched.add(dict.get(Integer.parseInt(String.valueOf(num))));
    }
    analyse("", 0);
    return result;
  }

  private String analyse(String resultStr, int index) {
    if (index == matched.size()) {
      result.add(resultStr);
      return "";
    }
    String[] strs = matched.get(index);
    for (String str : strs) {
      analyse(resultStr + str, index + 1);
    }
    return resultStr;
  }

  public static void main(String[] args) {
    LetterCombinations instance = new LetterCombinations();
    List<String> ans = instance.letterCombinations("23");
    for (String s : ans) {
      System.out.println(s);
    }
  }
}
