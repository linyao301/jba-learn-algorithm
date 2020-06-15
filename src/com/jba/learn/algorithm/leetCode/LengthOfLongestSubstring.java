package com.jba.learn.algorithm.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * <pre>
 *   给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class LengthOfLongestSubstring {

  public static int lengthOfLongestSubstring(String s) {
    Set<Character> occ = new HashSet<>();
    int n = s.length();
    int rk = -1, ans = 0;
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        occ.remove(s.charAt(i - 1));
      }
      while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
        occ.add(s.charAt(rk + 1));
        ++rk;
      }
      ans = Math.max(ans, rk - i + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

}
