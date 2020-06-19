package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <pre>
 *    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  <pre/>
 */
public class ThreeSum {

  /**
   * <pre>
   *   在排序之后重复需要达到三个条件
   *   1:当前元素和上一个元素一致需要排除
   *   2：当sum=0时，[Left]=[Left+1]需要跳过[Left+1]
   *   3：当sum=0是，[RIGHT]=[RIGHT-1]需要跳过[RIGHT+1]
   * </pre>
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    //为null时直接返回
    if (nums == null) {
      return result;
    }
    int len = nums.length;
    //长度小于3时直接返回
    if (len < 3) {
      return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < len - 2; i++) {
      //因已经排序，如果当前元素>0直接退出
      if (nums[i] > 0) {
        break;
      }
      //如果当前元素=前一个元素，避免重复跳过
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1, right = len - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          List<Integer> ans = new ArrayList<>();
          ans.add(nums[i]);
          ans.add(nums[left]);
          ans.add(nums[right]);
          result.add(ans);
          //当sum=0时，寻找左元素!=当前左元素的数，避免重复
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          //当sum=0时，需要右元素!=当前右元素，避免重复
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, 2, 2, -1, -4});
    System.out.println("OK");
  }
}
