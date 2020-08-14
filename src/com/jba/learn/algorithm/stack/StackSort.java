package com.jba.learn.algorithm.stack;

import java.util.Stack;

/**
 * <pre>
 *   用一个栈实现另一个栈的排序
 *   【题目】
 *   一个栈中元素的类型为整型，
 *   现在想将该栈从顶到底按从大到小的顺序排序，
 *   只许申请一个栈。除此之外，可以申请新的变量，
 *   但不能申请额外的数据结构。如何完成排序？
 * <pre/>
 */
public class StackSort {

  private Stack<Integer> help = new Stack<>();

  public void sort(Stack<Integer> stack) {
    while (!stack.isEmpty()) {
      Integer cur = stack.pop();
      while (!help.isEmpty() && cur > help.peek()) {
        stack.push(help.pop());
      }
      help.push(cur);
    }
    while (!help.isEmpty()) {
      stack.push(help.pop());
    }
  }

  public static void main(String[] args) {
    StackSort stackSort = new StackSort();
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(5);
    stackSort.sort(stack);
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + ",");
    }
  }
}
