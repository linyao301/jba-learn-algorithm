package com.jba.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * <pre>
 *   生成窗口最大值数组
 *   【题目】
 *   例如，数组为[4，3，5，4，3，3，6，7]，窗口大小为3时：
 *   如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
 *   请实现一个函数。
 *   ● 输入：整型数组arr，窗口大小为w。
 *   ● 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。以本题为例，结果应该返回{5，5，5，4，6，7}。
 * <pre/>
 */
public class WindowMaxValue {

  public int[] getMaxValue(int[] arr, int w) {
    if (arr == null || w < 1 || arr.length < w) {
      return null;
    }
    ArrayDeque<Integer> qmax = new ArrayDeque<>();
    int[] res = new int[arr.length - w + 1];
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
        qmax.pollLast();
      }
      qmax.addLast(i);
      if (qmax.peekFirst() == i - w) {
        qmax.pollFirst();
      }
      if (i >= w - 1) {
        res[index++] = arr[qmax.peekFirst()];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    WindowMaxValue windowMaxValue = new WindowMaxValue();
    int[] result = windowMaxValue.getMaxValue(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + ",");
    }
  }
}
