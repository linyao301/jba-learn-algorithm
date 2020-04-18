package com.jba.learn.algorithm.search;

/**
 * 二分查找
 */
public class BinarySearch {

  private static <T extends Integer> T binarySearch(T[] lists, T item) {
    int low = 0;
    int high = lists.length - 1;
    while (low <= high) {
      int mid = (int) Math.floor((low + high) / 2);
      T guess = lists[mid];
      if (guess.equals(item)) {
        return guess;
      }
      if (guess.compareTo(item) < 0) {
        low = mid + 1;
      }
      if (guess.compareTo(item) > 0) {
        high = mid - 1;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Integer[] test1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(binarySearch(test1, 1));
  }

}
