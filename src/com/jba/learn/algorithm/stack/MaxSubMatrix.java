package com.jba.learn.algorithm.stack;

import java.util.Stack;

/**
 * <pre>
 *   求最大子矩阵的大小
 *   【题目】
 *   给定一个整型矩阵map，其中的值只有0和1两种，
 *   求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
 * </pre>
 */
public class MaxSubMatrix {

  public int getNum(int[][] arr) {
    int maxArea = 0;
    if (arr.length == 0) {
      return maxArea;
    }
    int[] height = new int[arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        height[j] = arr[i][j] == 0 ? 0 : height[j] + 1;
      }
      maxArea = Math.max(maxRecFromBottom(height), maxArea);
    }
    return maxArea;
  }

  private int maxRecFromBottom(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && stack.peek() >= height[i]) {
        int j = stack.pop();
        int k = stack.isEmpty() ? -1 : stack.peek();
        int curArea = (i - k - 1) * height[j];
        maxArea = Math.max(maxArea, curArea);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int j = stack.pop();
      int k = stack.isEmpty() ? -1 : stack.peek();
      int curArea = (height.length - k - 1) * height[j];
      maxArea = Math.max(maxArea, curArea);
    }
    return maxArea;
  }


  public static void main(String[] args) {
    MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
    int[][] arr = new int[1][4];
    arr[0] = new int[]{1, 1, 1, 0};
    int result = maxSubMatrix.getNum(arr);
    System.out.println(result);
  }
}
