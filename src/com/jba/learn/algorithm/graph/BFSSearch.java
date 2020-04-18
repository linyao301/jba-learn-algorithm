package com.jba.learn.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BFSSearch {

  private static void search(HashMap<String, List<String>> graph, HashMap<String, Integer> position, String start) {
    List<String> nodes = graph.get(start);
    Queue<String> queue = new ArrayDeque<>();
    queue.addAll(nodes);
    for (String node : nodes) {
      position.put(node, 1);
    }
    while (!queue.isEmpty()) {
      String node = queue.poll();
      List<String> childNodes = graph.get(node);
      int posi = position.get(node) + 1;
      for (String childNode : childNodes) {
        if (!position.containsKey(childNode)) {
          queue.offer(childNode);
          position.put(childNode, posi);
        }
      }
    }
  }

  public static void main(String[] args) {
    List<String> s = new ArrayList<>();
    s.add("r");
    s.add("w");
    List<String> r = new ArrayList<>();
    r.add("s");
    r.add("v");
    List<String> i = new ArrayList<>();
    i.add("w");
    i.add("x");
    i.add("u");
    List<String> u = new ArrayList<>();
    u.add("i");
    u.add("x");
    u.add("y");
    List<String> v = new ArrayList<>();
    v.add("r");
    List<String> w = new ArrayList<>();
    w.add("s");
    w.add("x");
    List<String> x = new ArrayList<>();
    x.add("w");
    x.add("i");
    x.add("y");
    List<String> y = new ArrayList<>();
    y.add("x");
    y.add("u");
    HashMap<String, List<String>> graph = new HashMap<>();
    graph.put("s", s);
    graph.put("r", r);
    graph.put("i", i);
    graph.put("u", u);
    graph.put("v", v);
    graph.put("w", w);
    graph.put("x", x);
    graph.put("y", y);
    HashMap<String, Integer> position = new HashMap<>();
    search(graph, position, "s");
    Collection<Integer> values = position.values();
    List<Integer> values1 = values.stream().distinct().sorted().collect(Collectors.toList());
    for (Integer value : values1) {
      System.out.print(value + ":");
      position.forEach((k, v1) -> {
        if (v1.equals(value)) {
          System.out.print(k + ",");
        }
      });
      System.out.println("");
    }
  }

}
