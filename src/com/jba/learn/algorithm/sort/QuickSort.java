package com.jba.learn.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {

  private static void sort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivot = array[left];
    int i = left;
    int j = right;
    while (i < j) {
      while (array[j] > pivot && i < j) {
        j--;
      }
      while (array[i] <= pivot && i < j) {
        i++;
      }
      if (i < j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    array[left] = array[i];
    array[i] = pivot;
    sort(array, left, i - 1);
    sort(array, i + 1, right);
  }

  public static void main(String[] args) {
    String a=", 2, 7, 5, 8, 15, 7, 1";
    int[] array = new int[]{4, 3, 6};
    sort(array, 0, array.length - 1);
    for (int i : array) {
      System.out.print(i + ",");
    }
  }

}
