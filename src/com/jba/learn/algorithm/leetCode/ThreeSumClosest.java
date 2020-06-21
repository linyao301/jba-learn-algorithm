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
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) {
          return sum;
        }
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }
        if (sum < target) {
          left++;
        }
        if (sum > target) {
          right--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ThreeSumClosest instance = new ThreeSumClosest();
    System.out.println(instance.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
  }
}
