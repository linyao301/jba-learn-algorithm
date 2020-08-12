package com.jba.learn.algorithm.stack;

import java.util.Stack;

/**
 * <pre>
 *   如何仅用递归函数和栈操作逆序一个栈
 *   【题目】
 *   一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 *   将这个栈转置后，从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，
 *   但是只能用递归函数来实现，不能用其他数据结构。
 * <pre/>
 */
public class Reverse {

  private Object getLastEle(Stack<Object> stack) {
    Object result = stack.pop();
    if (stack.isEmpty()) {
      return result;
    }
    Object ele = getLastEle(stack);
    stack.push(result);
    return ele;
  }

  public void reverse(Stack<Object> stack) {
    if (stack.isEmpty()) {
      return;
    }
    Object result = getLastEle(stack);
    reverse(stack);
    stack.push(result);
  }

  public static void main(String[] args) {
    Stack<Object> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    Reverse reverse = new Reverse();
    reverse.reverse(stack);
    System.out.println("OK");
  }
}
