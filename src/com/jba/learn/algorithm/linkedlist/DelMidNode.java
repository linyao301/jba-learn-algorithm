package com.jba.learn.algorithm.linkedlist;

/**
 * <pre>
 *   给定链表的头节点head，实现删除链表的中间节点的函数。
 *   例如：不删除任何节点；
 *   1-＞2，删除节点1；
 *   1-＞2-＞3，删除节点2；1
 *   -＞2-＞3-＞4，删除节点2；
 *   1-＞2-＞3-＞4-＞5，删除节点3；
 * </pre>
 */
public class DelMidNode {

  public Node answer(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    int k = 0;
    Node cur = head;
    while (cur != null) {
      k++;
      cur = cur.next;
    }
    if (k == 0 || k == 1) {
      return head;
    }
    int mid = 0;
    if (k % 2 == 0) {
      mid = k / 2;
    } else if (k == 3) {
      mid = 2;
    } else {
      mid = (int) Math.ceil(k / 2f);
    }
    if (mid == 0) {
      return head;
    }
    if (mid == 1) {
      return head.next;
    }
    cur = head;
    while ((--mid) > 1) {
      cur = head.next;
    }
    cur.next = cur.next.next;
    return head;
  }

  /**
   * <pre>
   * 先来分析原问题，如果链表为空或者长度为 1，不需要调整，则直接返回；
   * 如果链表的长度为2，将头节点删除即可；
   * 当链表长度到达3，应该删除第2个节点；
   * 当链表长度为4，应该删除第2个节点；
   * 当链表长度为5，应该删除第3个节点……也就是链表长度每增加2
   * （3，5，7…），要删除的节点就后移一个节点。
   * 删除节点的问题在之前的题目中我们已经讨论过，
   * 如果要删除一个节点，则需要找到待删除节点的前一个节点。
   * </pre>
   *
   * @param head
   */
  public Node answer2(Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    if (head.next.next == null) {
      return head.next;
    }
    Node pre = head;
    Node cur = head.next.next;
    while (cur.next != null && cur.next.next != null) {
      pre = pre.next;
      cur = cur.next.next;
    }
    pre.next = pre.next.next;
    return head;
  }

  /**
   * <pre>
   * 进阶：给定链表的头节点head、整数a和b，实现删除位于a/b处节点的函数。
   * 例如：链表：1-＞2-＞3-＞4-＞5，
   * 假设a/b的值为r。
   * 如果r等于0，不删除任何节点；
   * 如果r在区间（0，1/5]上，删除节点1；
   * 如果r在区间（1/5，2/5]上，删除节点2；
   * 如果r在区间（2/5，3/5]上，删除节点3；
   * 如果r在区间（3/5，4/5]上，删除节点4；
   * 如果r在区间（4/5，1]上，删除节点5；
   * 如果r大于1，不删除任何节点。
   * </pre>
   */
  public Node advance(Node head, int a, int b) {
    /**
     * 由以上关系可得出公式(删除节点N)=a/b*n
     */
    int r = a / b;
    if (r == 0 || r > 1) {
      return head;
    }
    int n = 0;
    Node cur = head;
    while (cur != null) {
      n++;
      cur = cur.next;
    }
    int N = (int) Math.ceil((double) (a * n) / (double) b);
    if (N == 1) {
      return head.next;
    }
    if (N > 1) {
      Node pre = head;
      while (--N > 1) {
        pre = pre.next;
      }
      pre.next = pre.next.next;
    }
    return head;
  }

  public static void main(String[] args) {
    System.out.println(Math.ceil(5 / 2f));
    DelMidNode delMidNode = new DelMidNode();
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    node1.next = node2;
    Node node3 = new Node(3);
    node2.next = node3;
    Node node4 = new Node(4);
    node3.next = node4;
    Node node5 = new Node(5);
    node4.next = node5;
    Node result = delMidNode.answer(node1);
    while (result != null) {
      System.out.print(result.getValue() + ",");
      result = result.next;
    }
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
