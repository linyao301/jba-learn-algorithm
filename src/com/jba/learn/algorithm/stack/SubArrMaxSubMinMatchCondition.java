package com.jba.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubArrMaxSubMinMatchCondition {

  private Deque<Integer> maxQueue = new ArrayDeque<>();

  private Deque<Integer> minQueue = new ArrayDeque<>();

  private int[] arr;

  private int i = 0, j = 0;

  public int getNum(int[] arr, int num) {
    int result = 0;
    this.arr = arr;
    while (i < arr.length) {
      while (j < arr.length) {
        addPosition(j);
        int maxValue = getMaxValue();
        int minValue = getMinValue();
        if (maxValue - minValue > num) {
          break;
        }
        j++;
      }
      result += j - i;
      removePosition(i);
      i++;
    }
    return result;
  }

  private int getMaxValue() {
    return maxQueue.peekFirst();
  }

  private int getMinValue() {
    return minQueue.peekFirst();
  }

  private void addPosition(int index) {
    while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[index]) {
      maxQueue.pollLast();
    }
    maxQueue.addLast(index);
    while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[index]) {
      minQueue.pollLast();
    }
    minQueue.addLast(index);
  }

  private void removePosition(int index) {
    if (!maxQueue.isEmpty() && maxQueue.peekFirst() == index) {
      maxQueue.pollFirst();
    }
    if (!minQueue.isEmpty() && minQueue.peekFirst() == index) {
      minQueue.pollFirst();
    }
  }
}
