package com.jba.learn.algorithm.leetCode;

public class SearchRangeFind {

  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    int left = 0;
    int right = nums.length - 1;
    boolean find = false;
    int mid = 0;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        find = true;
        break;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (!find) {
      return new int[]{-1, -1};
    }
    left = mid;
    while (left >= 1) {
      if (nums[left - 1] == target) {
        left--;
        continue;
      }
      break;
    }
    right = mid;
    while (right <= nums.length - 2) {
      if (nums[right + 1] == target) {
        right++;
        continue;
      }
      break;
    }
    return new int[]{left, right};
  }

  public int[] searchRange1(int[] nums, int target) {
    int[] targetRange = {-1, -1};
    int leftIdx = extermeInsertionIndex(nums, target, true);
    if (leftIdx == nums.length || nums[leftIdx] != target) {
      return targetRange;
    }
    targetRange[0] = leftIdx;
    targetRange[1] = extermeInsertionIndex(nums, target, false) - 1;
    return targetRange;
  }

  private int extermeInsertionIndex(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (target == nums[mid]) {
        if (left) {
          hi = mid;
        } else {
          lo = mid + 1;
        }
        continue;
      }
      if (nums[mid] > target) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  public static void main(String[] args) {
    SearchRangeFind instance = new SearchRangeFind();
    int[] ans = instance.searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + ",");
    }
    ans = instance.searchRange1(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3);
    for (int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + ",");
    }
  }


}
