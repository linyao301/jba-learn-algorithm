package com.jba.learn.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Ergodic {


  /**
   * 前序遍历
   */
  private List<Integer> preOrder(TreeNode root) {
    List<Integer> lists = new ArrayList<>();
    if (root != null) {
      lists.add(root.value);
      preOrder(root.left);
      preOrder(root.right);
    }
    return lists;
  }

  //2.1中序遍历,递归实现
  public void inorder1(TreeNode root) {
    if (root != null) {
      inorder(root.left);
     // list.add(root.val);
      inorder(root.right);
    }
  }

  //2.2迭代和栈实现
  public void inorder(TreeNode root) {
    /*Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      list.add(root.val);
      root = root.right;
    }*/
  }

  //3.后序遍历
  public void backorder(TreeNode root) {
    /*if (root != null) {
      backorder(root.left);
      backorder(root.right);
      list.add(root.val);
    }*/
  }

  private static class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public TreeNode getLeft() {
      return left;
    }

    public void setLeft(TreeNode left) {
      this.left = left;
    }

    public TreeNode getRight() {
      return right;
    }

    public void setRight(TreeNode right) {
      this.right = right;
    }
  }

}
