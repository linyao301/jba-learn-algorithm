package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * <pre>
 *   给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums == null || nums.length < 4) {
      return ans;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      //如果当前元素=前一个元素，避免重复跳过
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        //如果当前元素=前一个元素，避免重复跳过
        if (j > (i + 1) && nums[j] == nums[j - 1]) {
          continue;
        }
        int left = j + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            left++;
            right--;
          }
          if (sum > target) {
            right--;
          }
          if (sum < target) {
            left++;
          }
        }
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    FourSum instance = new FourSum();
    List<List<Integer>> ans = instance.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    for (List<Integer> list : ans) {
      for (Integer s : list) {
        System.out.print(s + ",");
      }
      System.out.println("");
    }
  }

}
