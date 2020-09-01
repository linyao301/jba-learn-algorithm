package com.jba.learn.algorithm.linkedlist;

/**
 * 在单链表和双链表中删除倒数第K个节点
 * <pre>
 *   【题目】
 *   分别实现两个函数，一个可以删除单链表中倒数第K个节点，
 *   另一个可以删除双链表中倒数第K个节点
 *
 *   【要求】如果链表长度为N，时间复杂度达到O（N），
 *   额外空间复杂度达到O（1）。
 * </pre>
 */
public class DelLastNode {

  /**
   * 删除单链表倒数第K个节点
   */
  public SingleNode delSingleLinkedList(SingleNode head, int k) {
    if (head == null || k < 1) {
      return head;
    }
    SingleNode cur = head;
    while (cur != null) {
      --k;
      cur = cur.next;
    }
    if (k > 0) {
      return head;
    } else if (k == 0) {
      return head.next;
    } else {
      cur = head;
      while (++k != 0) {
        cur = cur.next;
      }
      cur.next = cur.next.next;
      return head;
    }
  }

  private static class SingleNode {

    private int value;
    private SingleNode next;

    public SingleNode(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public SingleNode getNext() {
      return next;
    }

    public void setNext(SingleNode next) {
      this.next = next;
    }
  }

  /**
   * 双链表中倒数第K个节点
   */
  public TwoNode delTwoLinkedList(TwoNode head, int k) {
    if (head == null || k < 1) {
      return head;
    }
    TwoNode cur = head;
    while (cur != null) {
      k--;
      cur = cur.next;
    }
    if (k == 0) {
      head = head.next;
      head.pre = null;
    } else if (k < 0) {
      cur = head;
      while (++k < 0) {
        cur = cur.next;
      }
      TwoNode next = cur.next.next;
      cur.next = next;
      if (next != null) {
        next.pre = cur;
      }
    }
    return head;
  }

  public static class TwoNode {

    private TwoNode pre;
    private TwoNode next;
    private int value;

    public TwoNode(TwoNode pre, int value) {
      this.pre = pre;
      this.value = value;
    }

    public TwoNode getPre() {
      return pre;
    }

    public void setPre(TwoNode pre) {
      this.pre = pre;
    }

    public TwoNode getNext() {
      return next;
    }

    public void setNext(TwoNode next) {
      this.next = next;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "TwoNode{" +
          "pre=" + (pre != null ? pre.getValue() : "null") +
          ", next=" + (next != null ? next.getValue() : "null") +
          ", value=" + value +
          '}';
    }
  }

  public static void main(String[] args) {
    DelLastNode delLastNode = new DelLastNode();
    SingleNode node1 = new SingleNode(1);
    SingleNode node2 = new SingleNode(2);
    SingleNode node3 = new SingleNode(3);
    node1.next = node2;
    node2.next = node3;
    SingleNode result = delLastNode.delSingleLinkedList(node1, 2);
    while (result != null) {
      System.out.print(result.getValue() + ",");
      result = result.next;
    }
    System.out.println("------");
    TwoNode tnode1 = new TwoNode(null, 1);
    TwoNode tnode2 = new TwoNode(tnode1, 2);
    tnode1.next = tnode2;
    TwoNode tnode3 = new TwoNode(tnode2, 3);
    tnode2.next = tnode3;
    TwoNode result2 = delLastNode.delTwoLinkedList(tnode1, 2);
    while (result2 != null) {
      System.out.println(result2.toString());
      result2 = result2.next;
    }
  }
}
