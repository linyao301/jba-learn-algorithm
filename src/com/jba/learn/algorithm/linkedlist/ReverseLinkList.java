package com.jba.learn.algorithm.linkedlist;

/**
 * 反转单向和双向链表
 */
public class ReverseLinkList {

  /**
   * 反转单向
   */
  public Node answer(Node head) {
    Node pre = null;
    Node next = null;
    while (head != null) {
      next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

  /**
   * 反转双向链表
   */
  public Node advance(Node head) {
    Node pre = null;
    Node next = null;
    while (head != null) {
      next = head.next;
      head.next = pre;
      head.pre = next;
      pre = head;
      head = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ReverseLinkList reverseLinkList = new ReverseLinkList();
    Node result = reverseLinkList.answer(buildNode());
    while (result != null) {
      System.out.println(result.getValue() + ",");
      result = result.next;
    }
    Node doubleNodes = buildDoubleNode();
    Node cur=doubleNodes;
    while (cur != null) {
      System.out.println(cur.toString());
      cur = cur.next;
    }
    result = reverseLinkList.advance(doubleNodes);
    while (result != null) {
      System.out.println(result.toString() + ",");
      result = result.next;
    }
  }

  public static Node buildNode() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    node1.next = node2;
    Node node3 = new Node(3);
    node2.next = node3;
    Node node4 = new Node(4);
    node3.next = node4;
    Node node5 = new Node(5);
    node4.next = node5;
    return node1;
  }

  public static Node buildDoubleNode() {
    Node node1 = new Node(1);
    Node node2 = new Node(node1, 2);
    node1.next = node2;
    Node node3 = new Node(node2, 3);
    node2.next = node3;
    Node node4 = new Node(node3, 4);
    node3.next = node4;
    Node node5 = new Node(node4, 5);
    node4.next = node5;
    return node1;
  }

  public static class Node {

    private int value;
    private Node pre;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(Node pre, int value) {
      this.value = value;
      this.pre = pre;
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

    @Override
    public String toString() {
      return "Node{" +
          "value=" + value +
          ", pre=" + (pre == null ? null : pre.value) +
          ", next=" + (next == null ? null : next.value) +
          '}';
    }
  }

}
