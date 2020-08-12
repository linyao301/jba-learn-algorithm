package com.jba.learn.algorithm.stack;

import java.util.Stack;

/**
 * <pre>
 *   由两个栈组成的队列
 *   【题目】编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 * <pre/>
 */
public class Queue {

  private final static Stack stack1 = new Stack();
  private final static Stack stack2 = new Stack();

  public void add(Object obj) {
    stack1.add(obj);
  }

  public Object poll() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.add(stack1.pop());
      }
    }
    if (!stack2.empty()) {
      return stack2.pop();
    }
    return null;
  }

  public Object peek() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.add(stack1.pop());
      }
    }
    if (!stack2.empty()) {
      return stack2.peek();
    }
    return null;
  }

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    while (queue.peek() != null) {
      System.out.print(queue.poll() + ",");
    }
  }

}
