package com.jba.learn.algorithm.stack;

import java.util.Stack;

/**
 * <pre>
 * <pre/>
 */
public class HanoiTower {

  public static class Problem1 {

    public int hanoiProblem1(int num, String left, String mid, String right) {
      if (num < 1) {
        return 0;
      }
      return process(num, left, mid, right, left, right);
    }

    //TODO 需要理解一下
    public int process(int num, String left, String mid, String right, String from, String to) {
      //处理一层的汉诺塔
      if (num == 1) {
        if (from.equals(mid) || to.equals(mid)) {
          System.out.println("Move 1 from " + from + " to " + to);
          return 1;
        } else {
          System.out.println("Move 1 from " + from + " to " + mid);
          System.out.println("Move 1 from " + mid + " to " + to);
        }
      }
      if (from.equals(mid) || to.equals(mid)) {
        //1）将1～N-1层塔先全部从“左”移到“右”，明显交给递归过程。
        //2）将第N层塔从“左”移到“中”。
        //3）再将1～N-1层塔全部从“右”移到“中”，明显交给递归过程。

      } else {
        //1）将1～N-1层塔先全部从“左”移到“右”，明显交给递归过程。
        //2）将第N层塔从“左”移到“中”。
        //3）将1～N-1层塔全部从“右”移到“左”，明显交给递归过程。
        //4）将第N层塔从“中”移到“右”。
        //5）将1～N-1层塔全部从“左”移到“右”，明显交给递归过程
      }
      return num;
    }
  }

  public static class Problem2 {

    private Stack<Integer> left;

    private Stack<Integer> mid;

    private Stack<Integer> right;

    public Problem2(Stack<Integer> stack) {
      this.left = stack;
      this.mid = new Stack<>();
      this.right = new Stack<>();
    }

    public void move() {

    }
  }


}
