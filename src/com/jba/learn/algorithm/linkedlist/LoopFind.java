package com.jba.learn.algorithm.linkedlist;

public class LoopFind {

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    n1.next = n2;
    n2.next = n3;
    n3.next = n1;
    System.out.println(hasLoop(n1));
  }

  private static boolean hasLoop(Node head) {
    if (head == null || head.next == null) {
      return false;
    }
    Node slow = head;
    Node quick = head;
    while (slow != null && quick.next != null) {
      slow = slow.next;
      quick = quick.next.next;
      if (slow == quick) {
        return true;
      }
    }
    return false;
  }

  private static class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }

}
