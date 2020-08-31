package com.jba.learn.algorithm.linkedlist;

/**
 * 打印两个有序链表的公共部分
 * <pre>
 *   给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 * </pre>
 */
public class CommPart {


  public void answer(Node h1, Node h2) {
    StringBuilder sb = new StringBuilder();
    while (h1 != null && h2 != null) {
      if (h1.getValue() == h2.getValue()) {
        sb.append(h1.getValue()).append(",");
        h1 = h1.next;
        h2 = h2.next;
      } else if (h1.getValue() < h2.getValue()) {
        h1 = h1.next;
      } else {
        h2 = h2.next;
      }
    }
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    Node h1 = new Node(1);
    h1.next = new Node(2);
    h1.next.next = new Node(3);
    Node h2 = new Node(2);
    h2.next = new Node(3);
    h2.next.next = new Node(4);
    CommPart commPart = new CommPart();
    commPart.answer(h1, h2);
  }

  public static class Node {

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
