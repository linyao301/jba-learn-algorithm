package com.jba.learn.algorithm.graph;

public class Sub extends Base{

  private String name = "sub";

  @Override
  public String getName() {
    return name;
  }

  public static void main(String[] args) {
    Base base=new Sub();
    System.out.println(base.getName());
  }
}
