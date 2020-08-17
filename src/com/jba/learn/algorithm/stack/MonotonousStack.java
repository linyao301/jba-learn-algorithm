package com.jba.learn.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *   单调栈结构
 *   【题目】给定一个不含有重复值的数组arr，
 *   找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。
 *   返回所有位置相应的信息。
 *   【举例】
 *   arr={3,4,1,5,6,2,7}
 *   返回如下二维数组作为结果：
 *   {
 *     {-1,2},
 *     {0,2},
 *     {-1,-1},
 *     {2,5},
 *     {3,5},
 *     {2,-1},
 *     {5,-1}
 *   }
 * </pre>
 */
public class MonotonousStack {

  public int[][] getNearLessNoRepeat(int[] arr) {
    int[][] res = new int[arr.length][2];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
        int popValue = stack.pop();
        res[popValue][0] = stack.isEmpty() ? -1 : stack.peek();
        res[popValue][1] = i;
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int popValue = stack.pop();
      res[popValue][0] = stack.isEmpty() ? -1 : stack.peek();
      res[popValue][1] = -1;
    }
    return res;
  }

  public int[][] getNearLess(int[] arr) {
    int[][] res = new int[arr.length][2];
    Stack<List<Integer>> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
        List<Integer> values = stack.pop();
        int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(0);
        for (Integer value : values) {
          res[value][0] = leftIndex;
          res[value][1] = i;
        }
      }
      if (!stack.isEmpty() && arr[stack.peek().get(0)] == (arr[i])) {
        stack.peek().add(i);
      } else {
        List<Integer> value = new ArrayList<>();
        value.add(i);
        stack.push(value);
      }
    }
    while (!stack.isEmpty()) {
      List<Integer> values = stack.pop();
      int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(0);
      for (Integer value : values) {
        res[value][0] = leftIndex;
        res[value][1] = -1;
      }
    }
    return res;
  }
}
