package com.jba.learn.algorithm.leetCode;

/**
 * 最长公共前缀
 * <pre>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String first = strs[0];
    for (int i = 0; i < first.length(); i++) {
      char match = first.charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || match != strs[j].charAt(i)) {
          return first.substring(0, i);
        }
      }
    }
    return first;
  }

  //region 二分查找
  public static String longestCommonPrefixWithDiv(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    int minLength = Integer.MAX_VALUE;
    for (String str : strs) {
      minLength = Math.min(minLength, str.length());
    }
    int low = 0;
    int high = minLength;
    while (low < high) {
      int mid = (high - low + 1) / 2 + low;
      if (match(strs, mid)) {
        low = mid;
      } else {
        high = mid - 1;
      }
    }
    return strs[0].substring(0, low);
  }

  private static boolean match(String[] strs, int length) {
    String str0 = strs[0].substring(0, length);
    int count = strs.length;
    for (int i = 1; i < count; i++) {
      String str = strs[i];
      for (int j = 0; j < length; j++) {
        if (str0.charAt(j) != str.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }
  //endregion

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[]{"abf", "abf"}));
    System.out.println(longestCommonPrefixWithDiv(new String[]{"abf", "abf"}));
  }
}
