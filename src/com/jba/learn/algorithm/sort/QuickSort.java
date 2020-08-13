package com.jba.learn.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {

  private static int leftTime = 0;

  private static void sortLeft(int[] array, int left, int right) {
    leftTime++;
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
    sortLeft(array, left, i - 1);
    sortLeft(array, i + 1, right);
  }

  private static int rightTime = 0;

  private static void sortRight(int[] array, int left, int right) {
    rightTime++;
    if (left >= right) {
      return;
    }
    int pivot = array[right];
    int i = left;
    int j = right;
    while (i < j) {
      while (array[i] < pivot && i < j) {
        i++;
      }
      while (array[j] >= pivot && i < j) {
        j--;
      }
      if (i < j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    array[right] = array[i];
    array[i] = pivot;
    sortRight(array, left, i - 1);
    sortRight(array, i + 1, right);
  }

  public static void main(String[] args) {
    String a = ", 2, 7, 5, 8, 15, 7, 1";
    int[] array = new int[]{6, 8, 2};
    sortLeft(array, 0, array.length - 1);
    for (int i : array) {
      System.out.print(i + ",");
    }
    /*System.out.println("");
    System.out.println(leftTime);
    array = new int[]{4, 3, 6, 2, 7, 5, 8, 15, 7, 1};
    sortRight(array, 0, array.length - 1);
    for (int i : array) {
      System.out.print(i + ",");
    }
    System.out.println("");
    System.out.println(rightTime);*/
  }

}
