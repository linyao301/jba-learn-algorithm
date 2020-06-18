package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.ListSelectionModel;

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

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int a1 = nums[i];
      for (int j = i + 1; j < nums.length - 1; j++) {
        int a2 = nums[j];
        for (int z = j + 1; z < nums.length; z++) {
          int a3 = nums[z];
          if (a1 + a2 + a3 == 0) {
            List<Integer> match = new ArrayList<>();
            match.add(a1);
            match.add(a2);
            match.add(a3);
            result.add(match);
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    System.out.println("OK");
  }
}
