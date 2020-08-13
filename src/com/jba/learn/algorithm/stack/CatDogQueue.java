package com.jba.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * <pre>
 *   猫狗队列
 *   实现一种狗猫队列的结构，要求如下：
 *   ● 用户可以调用add方法将cat类或dog类的实例放入队列中；
 *   ● 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 *   ● 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
 *   ● 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 *   ● 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 *   ● 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 *   ● 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * </pre>
 */
public class CatDogQueue {

  private long seq = 0;

  private Queue<PetEntry<Dog>> dog = new ArrayDeque();

  private Queue<PetEntry<Cat>> cat = new ArrayDeque<>();

  public void add(Pet pet) {
    if (pet instanceof Dog) {
      dog.add(new PetEntry<>((Dog) pet, ++seq));
    } else {
      cat.add(new PetEntry<>((Cat) pet, ++seq));
    }
  }

  public Pet pollAll() {
    PetEntry<Dog> dogEntry = null;
    PetEntry<Cat> catEntry = null;
    if (!dog.isEmpty()) {
      dogEntry = dog.peek();
    }
    if (!cat.isEmpty()) {
      catEntry = cat.peek();
    }
    if (dogEntry == null && catEntry == null) {
      return null;
    } else if (catEntry == null) {
      return dog.poll().getPet();
    } else if (dogEntry == null) {
      return cat.poll().getPet();
    } else if (dogEntry.getSeq() < catEntry.getSeq()) {
      return Objects.requireNonNull(dog.poll()).getPet();
    } else {
      return Objects.requireNonNull(cat.poll()).getPet();
    }
  }

  public Pet pollDog() {
    if (dog.isEmpty()) {
      return null;
    }
    return dog.poll().getPet();
  }

  public Pet pollCat() {
    if (cat.isEmpty()) {
      return null;
    }
    return cat.poll().getPet();
  }

  public boolean isEmpty() {
    return dog.isEmpty() && cat.isEmpty();
  }

  public boolean isDogEmpty() {
    return dog.isEmpty();
  }

  public boolean isCatEmpty() {
    return cat.isEmpty();
  }

  public static void main(String[] args) {
    CatDogQueue catDogQueue = new CatDogQueue();
    catDogQueue.add(new Dog());
    catDogQueue.add(new Cat());
    catDogQueue.add(new Dog());
    catDogQueue.add(new Cat());
    while (!catDogQueue.isEmpty()) {
      System.out.println(catDogQueue.pollAll().getType());
    }
  }

  private static class PetEntry<T extends Pet> {

    private T pet;
    private long seq;

    public PetEntry(T pet, long seq) {
      this.pet = pet;
      this.seq = seq;
    }

    public T getPet() {
      return pet;
    }

    public long getSeq() {
      return seq;
    }
  }

  public static class Pet {

    private String type;

    public Pet(String type) {
      this.type = type;
    }

    public String getType() {
      return type;
    }
  }


  public static class Dog extends Pet {

    public Dog() {
      super("dog");
    }
  }

  public static class Cat extends Pet {

    public Cat() {
      super("cat");
    }
  }
}
