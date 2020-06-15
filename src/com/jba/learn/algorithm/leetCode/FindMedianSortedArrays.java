package com.jba.learn.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double result = 0;
    List<Integer> lists = new ArrayList<>(nums1.length + nums2.length);
    int size1 = 0;
    int size2 = 0;
    while (size1 < nums1.length || size2 < nums2.length) {
      if (size1 == nums1.length) {
        lists.add(nums2[size2]);
        size2++;
        continue;
      }
      if (size2 == nums2.length) {
        lists.add(nums1[size1]);
        size1++;
        continue;
      }
      if (nums1[size1] <= nums2[size2]) {
        lists.add(nums1[size1]);
        size1++;
      } else {
        lists.add(nums2[size2]);
        size2++;
      }
    }
    if (lists.size() % 2 == 0) {
      int i = lists.size() / 2 - 1;
      int j = i + 1;
      result = (Double.parseDouble(lists.get(i).toString()) + Double.parseDouble(lists.get(j).toString())) / 2;
    } else {
      result = lists.get((lists.size() / 2));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    System.out.println((1 + 2) / 2);
  }
}
