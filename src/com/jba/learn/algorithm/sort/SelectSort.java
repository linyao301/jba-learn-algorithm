package com.jba.learn.algorithm.sort;

/**
 * 选择排序
 */
public class SelectSort {

  private static void sort(Integer[] lists) {
    for (int i = 0; i < lists.length; i++) {
      int minPos = i;
      for (int j = i + 1; j < lists.length; j++) {
        if (lists[minPos] > lists[j]) {
          minPos = j;
        }
      }
      if (i != minPos) {
        swapValue(lists, i, minPos);
      }
    }
  }

  private static void sort2(Integer[] lists) {
    for (int i = 0; i < lists.length; i++) {
      int min = i;
      for (int j = i + 1; j < lists.length; j++) {
        if (lists[min] > lists[j]) {
          min = j;
        }
      }
      if (min != i) {
        swapValue(lists, i, min);
      }
    }
  }

  private static void swapValue(Integer[] lists, int pos1, int pos2) {
    int temp = 0;
    temp = lists[pos1];
    lists[pos1] = lists[pos2];
    lists[pos2] = temp;
  }

  private static void print(Integer[] lists) {
    for (int item : lists) {
      System.out.print(item + ",");
    }
  }

  public static void main(String[] args) {
    Integer[] a = new Integer[]{3, 2, 4, 1};
    sort(a);
    print(a);
    System.out.println();
    Integer[] b = new Integer[]{4, 3, 6, 2, 6, 1, 9, 7};
    sort(b);
    print(b);
  }

}
