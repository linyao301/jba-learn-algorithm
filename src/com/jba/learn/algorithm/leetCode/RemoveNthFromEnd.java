package com.jba.learn.algorithm.leetCode;

/**
 * 删除链表的倒数第N个节点
 * <pre>
 *
 * <pre/>
 */
public class RemoveNthFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int length = 1;
    ListNode iterator = head;
    while (iterator.next != null) {
      length++;
      iterator = iterator.next;
    }
    int pos = length - n;
    if (pos == 0) {
      return head.next;
    }
    iterator = head;
    while (pos > 1) {
      iterator = iterator.next;
      pos--;
    }
    if (iterator.next != null) {
      iterator.next = iterator.next.next;
    }
    return head;
  }

  private ListNode buildListNode(int[] ints) {
    ListNode parent = new ListNode(ints[0]);
    ListNode head = parent;
    for (int i = 1; i < ints.length; i++) {
      ListNode child = new ListNode(ints[i]);
      parent.next = child;
      parent = child;
    }
    return head;
  }

  //region 优化
  public ListNode removeNthFromEndOptimize(ListNode head, int n) {
    ListNode prev = new ListNode(0);
    prev.next = head;
    ListNode start = prev, end = prev;
    while (n != 0) {
      start = start.next;
      n--;
    }
    while (start.next != null) {
      start = start.next;
      end = end.next;
    }
    end.next = end.next.next;
    return prev.next;
  }
  //endregion

  public static void main(String[] args) {
    RemoveNthFromEnd instance = new RemoveNthFromEnd();
    ListNode listNode = instance.buildListNode(new int[]{1, 2, 3});
    ListNode ans = instance.removeNthFromEndOptimize(listNode, 2);
    String str = String.valueOf(ans.val);
    while (ans.next != null) {
      ans = ans.next;
      str += "," + ans.val;
    }
    System.out.println(str);
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
