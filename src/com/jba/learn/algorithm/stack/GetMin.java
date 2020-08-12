package com.jba.learn.algorithm.stack;

import java.util.Stack;

/**
 * <pre>
 * 设计一个有getMin功能的栈【题目】实现一个特殊的栈，
 * 在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】
 * 1.pop、push、getMin操作的时间复杂度都是O（1）。
 * 2.设计的栈类型可以使用现成的栈结构。
 * <pre/>
 */
public class GetMin {

  public static void main(String[] args) {
    System.out.println("METHOD1");
    CustomStack1 customStack1 = new CustomStack1();
    customStack1.push(3);
    customStack1.push(4);
    customStack1.push(5);
    customStack1.push(1);
    customStack1.push(2);
    customStack1.push(1);
    while (!customStack1.empty()) {
      System.out.println("MIN VALUE:" + customStack1.getMin());
      System.out.println("AFTER POP VALUE:" + customStack1.pop());
    }
    System.out.println("METHOD2");
    CustomStack1 customStack2 = new CustomStack1();
    customStack2.push(3);
    customStack2.push(4);
    customStack2.push(5);
    customStack2.push(1);
    customStack2.push(2);
    customStack2.push(1);
    while (!customStack2.empty()) {
      System.out.println("MIN VALUE:" + customStack2.getMin());
      System.out.println("AFTER POP VALUE:" + customStack2.pop());
    }
  }

  public static class CustomStack1 {

    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack<>();

    public boolean empty() {
      return stack.empty();
    }

    public void push(Integer v) {
      this.stack.push(v);
      if (this.minStack.empty() || this.minStack.peek() >= v) {
        this.minStack.push(v);
      }
    }

    public Integer pop() {
      Integer v = this.stack.pop();
      if (this.minStack.peek().equals(v)) {
        this.minStack.pop();
      }
      return v;
    }

    public Integer getMin() {
      return this.minStack.peek();
    }
  }

  public static class CustomStack2 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public boolean empty() {
      return stack.empty();
    }

    public void push(Integer v) {
      this.stack.push(v);
      if (this.minStack.empty() || this.minStack.peek() >= v) {
        this.minStack.push(v);
      } else {
        Integer minV = this.minStack.peek();
        this.minStack.push(minV);
      }
    }

    public Integer pop() {
      this.stack.pop();
      return this.stack.pop();
    }

    public Integer getMin() {
      return this.minStack.peek();
    }
  }
}
