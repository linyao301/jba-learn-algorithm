package com.jba.learn.algorithm.stack;

/**
 * 可见的山峰对数量
 * <pre>
 * 一个不含有负数的数组可以代表一圈环形山，每个位置的值代表山的高度。
 * 比如，{3，1，2，4，5}、{4，5，3，1，2}或{1，2，4，5，3}
 * 都代表同样结构的环形山。3-＞1-＞2-＞4-＞5-＞3方向叫作
 * next方向（逆时针），3-＞5-＞4-＞2-＞1-＞3方向
 * 叫作last方向（顺时针）
 *
 * 山峰A和山峰B能够相互看见的条件为：
 * 1.如果A和B是同一座山，认为不能相互看见。
 * 2.如果A和B是不同的山，并且在环中相邻，认为可以相互看见。比如图1-8中，相邻的山峰对有（1，2）（2，4）（4，5）（3，5）（1，3）。3.如果A和B是不同的山，并且在环中不相邻，假设两座山高度的最小值为min。如果A通过next方向到B的途中没有高度比min大的山峰，或者A通过last方向到B的途中没有高度比min大的山峰，认为A和B可以相互看见。比如图1-8中，高度为3的山和高度为4的山，两座山的高度最小值为3。
 * 3从last方向走向4，中途会遇见5，所以last方向走不通；3从next方向走向4，中途会遇见1和2，但是都不大于两座山高度的最小值3，所以next方向可以走通。有一个能走通就认为可以相互看见。再如，高度为2的山和高度为5的山，两个方向上都走不通，所以不能相互看见。图1-8中所有在环中不相邻，并且能看见的山峰对有（2，3）（3，4）。给定一个不含有负数且没有重复值的数组arr，请返回有多少对山峰能够相互看见。
 * </pre>
 */
public class SoPeakNum {

  public int getNum(int[] arr) {
    if (arr.length == 0 || arr.length == 1) {
      return 0;
    }
    if (arr.length == 2) {
      return 1;
    }
    return (arr.length - 2) * 2 + 1;
  }

  /**
   * <pre>
   *   进阶问题：给定一个不含有负数但可能含有重复值的数组arr，
   *   返回有多少对山峰能够相互看见
   * </pre>
   */
  public int getAdvanceNum(int[] arr) {
    //TODO 暂未实现
    return 0;
  }

  public static void main(String[] args) {
    SoPeakNum soPeakNum = new SoPeakNum();
    int num = soPeakNum.getNum(new int[]{3, 1, 2, 4, 5});
    System.out.println(num);
  }
}
