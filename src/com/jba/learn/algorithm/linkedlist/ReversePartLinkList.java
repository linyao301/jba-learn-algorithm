package com.jba.learn.algorithm.linkedlist;

/**
 * 反转部分单向链表
 * <pre>
 * 【题目】给定一个单向链表的头节点head，以及两个整数from和to，
 * 在单向链表上把第from个节点到第to个节点这一部分进行反转。
 * 例如：1-＞2-＞3-＞4-＞5-＞null,from=2,to=4
 * 调整结果为：1-＞4-＞3-＞2-＞5-＞null
 * 再如：1-＞2-＞3-＞null,from=1,to=3
 * 调整结果为：3-＞2-＞1-＞null
 * </pre>
 */
public class ReversePartLinkList {

  /**
   * <pre>
   * 【要求】
   * 1.如果链表长度为N，时间复杂度要求为O（N），额外空间复杂度要求为O（1）。
   * 2.如果不满足1＜=from＜=to＜=N，则不用调整。
   * </pre>
   */
  public Node answer(Node head, int from, int to) {
    /**
     * 本题有可能存在换头的问题，比如题目的第二个例子，所以函数
     * 应该返回调整后的新头节点，整个处理过程如下：
     * 1.先判断是否满足1≤from≤to≤N，如果不满足，则直接返回原来的头节点。
     * 2.找到第from-1个节点fPre和第to+1个节点tPos。
     * fPre就是要反转部分的前一个节点，tPos是反转部分的后一个节点。
     * 把反转的部分先反转，然后正确地连接fPre和tPos。
     * 例如：1-＞2-＞3-＞4-＞null，假设fPre为节点1，tPos为节点4，
     * 要反转部分为2-＞3。先反转成3-＞2，然后fPre连向节点3，节点2连向tPos，
     * 就变成了1-＞3-＞2-＞4-＞null。
     * 3.如果fPre为null，说明反转部分是包含头节点的，则返回新的头节点，
     * 也就是没反转之前反转部分的最后一个节点，也是反转之后反转部分的第一个节点；
     * 如果fPre不为null，则返回旧的头节点。全部过程请参看如下代码中的reversePart方法。
     */
    Node fPre = null;
    Node tPos = null;
    Node cur = head;
    int len = 0;
    while (cur != null) {
      len++;
      if (len == from - 1) {
        fPre = cur;
      }
      if (len == to + 1) {
        tPos = cur;
      }
      cur = cur.next;
    }
    if (from < 1 || from > to || to > len) {
      return head;
    }
    Node node1 = fPre == null ? head : fPre.next;
    Node node2 = node1.next;
    node1.next = tPos;
    Node next = null;
    while (node2 != tPos) {
      next = node2.next;
      node2.next = node1;
      node1 = node2;
      node2 = next;
    }
    if (fPre != null) {
      fPre.next = node1;
      return head;
    }
    return node1;
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
