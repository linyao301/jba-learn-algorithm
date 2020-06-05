package com.jba.learn.algorithm.leetCode;

/**
 * 改变一个整数能得到的最大差值
 * <pre>
 *   给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 *
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 *
 * 请你返回 a 和 b 的 最大差值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class MaxDiff {

  public static int maxDiff(int num) {
    String numStr = String.valueOf(num);
    char[] numChars = numStr.toCharArray();
    String findNum = "";
    String replaceNum = "";
    for (int i = 0; i < numChars.length; i++) {
      if (i == 0 && numChars[i] != '1') {
        findNum = String.valueOf(numChars[i]);
        replaceNum = "1";
        break;
      }
      if (i == numChars.length - 1 && numChars[i] == '1') {
        findNum = String.valueOf(numChars[i]);
        replaceNum = "1";
        break;
      }
      if (numChars[i] != '0' && numChars[i] != '1') {
        findNum = String.valueOf(numChars[i]);
        replaceNum = "0";
        break;
      }
    }
    int minNum = Integer.parseInt(numStr.replace(findNum, replaceNum));
    for (int i = 0; i < numChars.length; i++) {
      if (numChars[i] != '9') {
        findNum = String.valueOf(numChars[i]);
        break;
      }
    }
    int maxNum = Integer.parseInt(numStr.replace(findNum, "9"));
    return maxNum - minNum;
  }

  public static void main(String[] args) {
    System.out.println(maxDiff(111));
  }
}
