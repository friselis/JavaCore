package ru.geekbrains.fruits;

import java.util.ArrayList;

public class Box<T extends Fruit> {

  private final ArrayList<T> fruits = new ArrayList<T>();

  public void put(T fruit) {
    fruits.add(fruit);
  }

  public  <T1 extends Fruit> boolean compare(Box<T1> other) {
    return Math.abs(getWeight() - other.getWeight()) < 1e-7;
  }

  public float getWeight() {
    if (fruits.isEmpty()) {
      return 0;
    }
    return fruits.size() * fruits.get(0).getWeight();
  }

  public void moveTo(Box<T> other) {
    for (T fruit : fruits) {
      other.put(fruit);
    }
    fruits.clear();
  }

  @Override
  public String toString() {
    return "Box" + fruits.toString();
  }
}
