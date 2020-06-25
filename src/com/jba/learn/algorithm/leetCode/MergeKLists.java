package com.jba.learn.algorithm.leetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并K个排序链表
 * <pre>
 *   合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <pre/>
 */
public class MergeKLists {

  //region 两两合并
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }
    ListNode cur = lists[0];
    for (int i = 1; i < lists.length; i++) {
      ListNode l2 = lists[i];
      cur = mergeTwoList(cur, l2);
    }
    return cur;
  }

  private ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode pre = new ListNode(0);
    ListNode cur = pre;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      }
      cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return pre.next;
  }

  //endregion

  //region K指针（在链表数组里找最小数，然后将最小数所在链表往后移一个元素）
  public ListNode mergeKListsByKPoint(ListNode[] lists) {
    int k = lists.length;
    ListNode prev = new ListNode(0);
    ListNode tail = prev;
    while (true) {
      ListNode minNode = null;
      int minPointer = -1;
      for (int i = 0; i < k; i++) {
        if (lists[i] == null) {
          continue;
        }
        if (minNode == null || lists[i].val < minNode.val) {
          minNode = lists[i];
          minPointer = i;
        }
      }
      if (minPointer == -1) {
        break;
      }
      tail.next = minNode;
      tail = tail.next;
      lists[minPointer] = lists[minPointer].next;
    }
    return prev.next;
  }
  //endregion

  //region 小根堆
  public ListNode mergeKListsHeap(ListNode[] lists) {
    Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
    for (ListNode node : lists) {
      if (node != null) {
        pq.offer(node);
      }
    }
    ListNode prev = new ListNode(0);
    ListNode cur = prev;
    while (!pq.isEmpty()) {
      ListNode minNode = pq.poll();
      cur.next = minNode;
      cur = cur.next;
      if (minNode.next != null) {
        pq.offer(minNode.next);
      }
    }
    return prev.next;
  }
  //endregion

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
    MergeKLists instance = new MergeKLists();
    ListNode l1 = instance.buildNode(new int[]{1, 4, 5});
    ListNode l2 = instance.buildNode(new int[]{1, 3, 4});
    ListNode l3 = instance.buildNode(new int[]{2, 6});
    ListNode ans = instance.mergeKLists(new ListNode[]{l1, l2, l3});
    System.out.println("合并两个");
    while (ans != null) {
      System.out.print(ans.val + ",");
      ans = ans.next;
    }
    System.out.println();
    System.out.println("K指针");
    l1 = instance.buildNode(new int[]{1, 4, 5});
    l2 = instance.buildNode(new int[]{1, 3, 4});
    l3 = instance.buildNode(new int[]{2, 6});
    ans = instance.mergeKListsByKPoint(new ListNode[]{l1, l2, l3});
    while (ans != null) {
      System.out.print(ans.val + ",");
      ans = ans.next;
    }
    System.out.println();
    System.out.println("队列");
    l1 = instance.buildNode(new int[]{1, 4, 5});
    l2 = instance.buildNode(new int[]{1, 3, 4});
    l3 = instance.buildNode(new int[]{2, 6});
    ans = instance.mergeKListsHeap(new ListNode[]{l1, l2, l3});
    while (ans != null) {
      System.out.print(ans.val + ",");
      ans = ans.next;
    }
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

}
