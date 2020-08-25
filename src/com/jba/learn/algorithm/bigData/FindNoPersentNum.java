package com.jba.learn.algorithm.bigData;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *   40亿个非负整数中找到未出现的数
 *   【题目】
 *   32位无符号整数的范围是0～4 294 967 295，现在有一个正
 *   好包含40亿个无符号整数的文件，
 *   所以在整个范围中必然有未出现过的数。
 *   可以使用最多1GB的内存，怎么找到所有未出现过的数？
 * </pre>
 */
public class FindNoPersentNum {

  /**
   * <pre>
   * 使用bitMap计数
   * 申请一个长度为4 294 967295的bit类型的数组bitArr，
   * bitArr上的每个位置只可以表示0或1状态。
   * 8个bit为1B，所以长度为4 294 967 295的bit类型的数组占用500MB空间。
   * 怎么使用这个 bitArr 数组呢？就是遍历这 40 亿个无符号数，
   * 例如，遇到 7000，就把bitArr[7000]设置为1。
   * 遇到所有的数时，就把bitArr相应位置的值设置为1。
   * 遍历完成后，再依次遍历bitArr，
   * 哪个位置上的值没被设置为1，这个数就不在40亿个数中。
   * 例如，发现bitArr[8001]==0，那么8001就是没出现过的数，
   * 遍历完bitArr之后，所有没出现的数就都找出来了。
   * <pre/>
   */
  public void answer() {
    long length = 4_294_967_295L;
    Map<Long, Integer> bitMap = new HashMap<>();
  }

  /**
   * 内存限制为10MB，但是只用找到一个没出现过的数即可。
   */
  public void advanced() {
    /**
     * 1：0～4 294 967 295分成16个区间范围
     * 2：遍历文件，将num位于的区间X=(num/67 108 863)加一
     * 3：遍历16个区间范围，查找未达到67 108 863的区间Y
     * 4：对未达到区间Y进行bitMap遍历，得到随机的未出现的数
     */
  }

}
