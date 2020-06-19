package com.jba.learn.algorithm.leetCode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * <pre>
 *
 * <pre/>
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return target;
    }
    int subValue = Integer.MAX_VALUE;
    int result = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < subValue) {
          subValue = Math.abs(sum - target);
          result = sum;
        }
        while (left < right && nums[left++] == nums[right--]) {
          left++;
          right--;
        }

        left++;
        right--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ThreeSumClosest instance = new ThreeSumClosest();
    System.out.println(instance.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
  }
}
