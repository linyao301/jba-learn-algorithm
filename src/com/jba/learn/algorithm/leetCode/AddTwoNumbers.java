package com.jba.learn.algorithm.leetCode;

/**
 * 两数相加
 * <pre>
 *   给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class AddTwoNumbers {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0);
    ListNode p1 = l1, p2 = l2, curr = result;
    int carray = 0;
    while (p1 != null || p2 != null) {
      int x = p1 == null ? 0 : p1.val;
      int y = p2 == null ? 0 : p2.val;
      int sum = carray + x + y;
      carray = sum / 10;
      curr.next = new ListNode(sum % 10);
      curr = curr.next;
      if (p1 != null) {
        p1 = p1.next;
      }
      if (p2 != null) {
        p2 = p2.next;
      }
    }
    if (carray > 0) {
      curr.next = new ListNode(carray);
    }
    return result.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    System.out.println(addTwoNumbers(l1, l2));
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
