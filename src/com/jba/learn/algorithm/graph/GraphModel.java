package com.jba.learn.algorithm.graph;

/**
 * 图的表示法
 */
public class GraphModel {

  /**
   * 使用矩阵表示
   */
  public static class Matrix {

    String[][] graphs = new String[2][2];

    public void fillData() {
      graphs[0][0] = "0";
      graphs[0][1] = "0";
      graphs[1][0] = "1";
      graphs[1][1] = "1";
    }
  }

  /**
   * 使用邻接表表示
   */
  public static class AdjacencyList {

    //前邻接点
    private Node<String> prevAdjvert = new Node<>(null, "prevNode", null);
    //后邻接点
    private Node<String> nextAdjvert = new Node<>(null, "nextNode", null);
    //顶点
    private Node<String> vertex = new Node<>(prevAdjvert, "VertexNode", nextAdjvert);
  }

  private static class Node<E> {

    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }
  }
}
