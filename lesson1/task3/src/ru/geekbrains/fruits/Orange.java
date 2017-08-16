package ru.geekbrains.fruits;

public class Orange extends Fruit {

  private static final float ORANGE_WEIGHT = 1.5f;

  @Override
  public float getWeight() {
    return ORANGE_WEIGHT;
  }

  @Override
  public String toString() {
    return "orange";
  }
}
