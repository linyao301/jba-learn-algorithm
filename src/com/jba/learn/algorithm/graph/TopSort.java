package com.jba.learn.algorithm.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/**
 * 拓扑排序
 */
public class TopSort {


  static Map<String, Vertex> vertices = new HashMap<>(7);

  static void buildGraph() {
    Vertex v1 = new Vertex("v1");
    vertices.put("v1", v1);
    Vertex v2 = new Vertex("v2");
    vertices.put("v2", v2);
    Vertex v3 = new Vertex("v3");
    vertices.put("v3", v3);
    Vertex v4 = new Vertex("v4");
    vertices.put("v4", v4);
    Vertex v5 = new Vertex("v5");
    vertices.put("v5", v5);
    Vertex v6 = new Vertex("v6");
    vertices.put("v6", v6);
    Vertex v7 = new Vertex("v7");
    vertices.put("v7", v7);
    v1.adjacent.add(v2);
    v1.adjacent.add(v3);
    v1.adjacent.add(v4);
    v2.adjacent.add(v4);
    v2.adjacent.add(v5);
    v3.adjacent.add(v6);
    v4.adjacent.add(v3);
    v4.adjacent.add(v6);
    v4.adjacent.add(v7);
    v5.adjacent.add(v4);
    v5.adjacent.add(v7);
    v7.adjacent.add(v6);
    for (Entry<String, Vertex> entry : vertices.entrySet()) {
      for (Vertex adjacent : entry.getValue().adjacent) {
        adjacent.indegree++;
      }
    }
  }

  static void simpleTopSort(Set<String> checked) throws CycleFoundException {
    int NUM_VERTICES = vertices.size();
    for (int count = 0; count < NUM_VERTICES; count++) {
      Vertex v = findNewVertexOfIndegreeZero(checked);
      if (v == null) {
        throw new CycleFoundException();
      }
      LinkedList<Vertex> adjacents = v.adjacent;
      for (Vertex adjacent : adjacents) {
        adjacent.indegree--;
      }
      checked.add(v.name);
    }
  }

  /**
   * 查找没有入度的顶点
   */
  static Vertex findNewVertexOfIndegreeZero(Set<String> checked) {
    for (Entry<String, Vertex> entry : vertices.entrySet()) {
      Vertex vertex = entry.getValue();
      if (!checked.contains(entry.getKey()) && vertex.indegree == 0) {
        return vertex;
      }
    }
    return null;
  }

  static void optimialTopSort(Set<String> checked) {
    Queue<Vertex> queue = new ArrayDeque<>();
    for (Entry<String, Vertex> entry : vertices.entrySet()) {
      if (entry.getValue().indegree == 0) {
        queue.offer(entry.getValue());
      }
    }
    while (!queue.isEmpty()) {
      Vertex vertex = queue.poll();
      checked.add(vertex.name);
      LinkedList<Vertex> adjacents = vertex.adjacent;
      for (Vertex adjacent : adjacents) {
        adjacent.indegree--;
        if (adjacent.indegree == 0) {
          queue.offer(adjacent);
        }
      }
    }
  }

  public static void main(String[] args) {
    buildGraph();
    //简单拓扑排序
    Set<String> checked = new LinkedHashSet<>();
    while (checked.size() < vertices.size()) {
      simpleTopSort(checked);
    }
    for (String vertex : checked) {
      System.out.print(vertex + ",");
    }
    System.out.println("");
    vertices.clear();
    buildGraph();
    //优化后的拓扑排序
    checked = new LinkedHashSet<>();
    optimialTopSort(checked);
    if (checked.size() != vertices.size()) {
      throw new CycleFoundException();
    }
    for (String vertex : checked) {
      System.out.print(vertex + ",");
    }
  }

}
