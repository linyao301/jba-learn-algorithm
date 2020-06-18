package com.jba.learn.algorithm.leetCode;

/**
 * 盛最多水的容器
 * <pre>
 *   给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class MaxArea {

  private static int maxArea(int[] height) {
    int max = 0;
    int len = height.length;
    for (int i = 1; i <= len; i++) {
      for (int j = len; j > i; j--) {
        int result = (j - i) * Math.min(height[i - 1], height[j - 1]);
        if (result > max) {
          max = result;
        }
      }
    }
    return max;
  }

  //region 双指针
  private static int maxAreaDouble(int[] height) {
    int max = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      int xLen = right - left;
      int leftV = height[left];
      int rightV = height[right];
      int result = Math.min(leftV, rightV) * xLen;
      if (result > max) {
        max = result;
      }
      if (leftV < rightV) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }
  //endregion

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println(maxAreaDouble(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

}
