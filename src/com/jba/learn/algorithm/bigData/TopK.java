package com.jba.learn.algorithm.bigData;

/**
 * <pre>
 *   找到100亿个URL中重复的URL及搜索词汇的Top K问题
 *   【题目】
 *   有一个包含100亿个URL的大文件，假设每个URL占用64B，
 *   请找出其中所有重复的URL。
 * </pre>
 */
public class TopK {

  public void answer() {
    /**
     * 将100亿字节的大文件通过哈希函数分配到100台机器上，
     * 然后每一台机器分别统计分给自己的URL中是否有重复的URL，
     * 同时哈希函数的性质决定了同一条URL不可能分给不同的机器；
     * 或者在单机上将大文件通过哈希函数拆成1000个小文件，
     * 对每一个小文件再利用哈希表遍历，找出重复的URL；
     * 还可以在分给机器或拆完文件之后进行排序，排序过后再看是否有重复的URL出现。
     * 总之，牢记一点，很多大数据问题都离不开分流，
     * 要么是用哈希函数把大文件的内容分配给不同的机器，
     * 要么是用哈希函数把大文件拆成小文件，
     * 然后处理每一个小数量的集合。
     */
  }

  /**
   * 补充问题：某搜索公司一天的用户搜索词汇是海量的（百亿数据量）， 请设计一种求出每天热门Top 100词汇的可行办法。
   */
  public void advance() {
    /**
     * 把包含百亿数据量的词汇文件分流到不同的机器上，
     * 具体多少台机器由面试官规定或者由更多的限制来决定。
     * 对每一台机器来说，如果分到的数据量依然很大，
     * 比如，内存不够或存在其他问题，
     * 可以再用哈希函数把每台机器的分流文件拆成更小的文件处理。
     * 处理每一个小文件的时候，通过哈希表统计每种词及其词频，
     * 哈希表记录建立完成后，再遍历哈希表，
     * 遍历哈希表的过程中使用大小为100的小根堆来选出每一个小文件的Top 100
     * （整体未排序的Top 100）。每一个小文件都有自己词频的小根堆
     * （整体未排序的Top 100），将小根堆里的词按照词频排序，
     * 就得到了每个小文件的排序后Top 100。
     * 然后把各个小文件排序后的Top 100进行外排序或者继续利用小根堆，
     * 就可以选出每台机器上的Top 100。不同机器之间的Top 100再进行
     * 外排序或者继续利用小根堆，最终求出整个百亿数据量中的Top100。
     * 对于Top K的问题，除用哈希函数分流和用哈希表做词频统计之外，
     * 还经常用堆结构和外排序的手段进行处理。
     */
  }

}
