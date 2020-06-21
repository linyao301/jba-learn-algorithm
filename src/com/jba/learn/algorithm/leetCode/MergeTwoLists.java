package com.jba.learn.algorithm.leetCode;

import java.util.List;

/**
 * 合并两个有序链表
 * <pre>
 *   将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class MergeTwoLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode cur = ans;
    while (l1 != null && l2 != null) {
      if (l1.val >= l2.val) {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return ans.next;
  }

  public ListNode buildNode(int[] ints) {
    ListNode root = new ListNode(ints[0]);
    ListNode cur = root;
    for (int i = 1; i < ints.length; i++) {
      cur.next = new ListNode(ints[i]);
      cur = cur.next;
    }
    return root;
  }

  public static void main(String[] args) {
    MergeTwoLists instance = new MergeTwoLists();
    ListNode l1 = instance.buildNode(new int[]{1, 2, 4});
    ListNode l2 = instance.buildNode(new int[]{1, 3, 4});
    ListNode ans = instance.mergeTwoLists(l1, l2);
    while (ans != null) {
      System.out.print(ans.val + ",");
      ans = ans.next;
    }
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
