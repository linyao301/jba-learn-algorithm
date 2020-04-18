package com.jba.learn.algorithm.graph;

import java.util.LinkedList;

/**
 * 顶点对象
 */
public class Vertex {

  /**
   * 顶点名
   */
  public String name;
  /**
   * 入度
   */
  public int indegree;
  /**
   * 邻接点
   */
  public LinkedList<Vertex> adjacent;

  public Vertex(String name) {
    this.name = name;
    this.indegree = 0;
    this.adjacent = new LinkedList<Vertex>();
  }

}
