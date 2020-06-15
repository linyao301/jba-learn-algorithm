package com.jba.learn.algorithm.leetCode;

/**
 * 最长回文子串
 * <pre>
 *   给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class LongestPalindrome {

  //region 暴力匹配

  /**
   * 暴力匹配
   */
  public static String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    char[] chars = s.toCharArray();
    int begin = 0;
    int maxLen = 1;
    for (int i = 0; i < chars.length; i++) {
      for (int j = i; j < chars.length; j++) {
        if (j - i + 1 > maxLen && valid(chars, i, j)) {
          begin = i;
          maxLen = j - i + 1;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  private static boolean valid(char[] chars, int i, int j) {
    while (i < j) {
      if (chars[i] != chars[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  //endregion

  //region 动态规划
  public static String longestPalindromeWithDynamic(String s) {
    if (s.length() < 2) {
      return s;
    }
    char[] chars = s.toCharArray();
    int len = s.length();
    boolean[][] status = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      status[i][i] = true;
    }
    int begin = 0;
    int maxLen = 1;
    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (chars[i] != chars[j]) {
          status[i][j] = false;
        } else {
          if (j - i < 3) {
            //字符长度为3，且首尾相等即可判true
            status[i][j] = true;
          } else {
            status[i][j] = status[i + 1][j - 1];
          }
        }
        if (status[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;

        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }
  //endregion

  //region 中心扩散
  public static String longestPalindromeCenter(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    String res = s.substring(0, 1);
    for (int i = 0; i < len - 1; i++) {
      String oddStr = centerSpread(s, i, i);
      String eventStr = centerSpread(s, i, i + 1);
      String maxLenStr = oddStr.length() > eventStr.length() ? oddStr : eventStr;
      if (maxLenStr.length() > maxLen) {
        maxLen = maxLenStr.length();
        res = maxLenStr;
      }
    }
    return res;
  }

  private static String centerSpread(String s, int left, int right) {
    //left=right的时候，此时回文中心是一个字符，回文串的长度是奇数
    //right=left+1的时候，此时回文中心一个间隙，回文串的长度是偶数
    int len = s.length();
    int i = left;
    int j = right;
    while (i >= 0 && j < len) {
      if (s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
      } else {
        break;
      }
    }
    return s.substring(i + 1, j);
  }
  //endregion

  public static void main(String[] args) {
    System.out.println(longestPalindrome("dbbd"));
    System.out.println(longestPalindromeWithDynamic("dbbd"));
    System.out.println(longestPalindromeCenter("dbbd"));
  }
}
