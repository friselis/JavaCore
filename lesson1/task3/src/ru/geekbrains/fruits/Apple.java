package ru.geekbrains.fruits;

public class Apple extends Fruit {

  private static final float APPLE_WEIGHT = 1.0f;

  @Override
  public float getWeight() {
    return APPLE_WEIGHT;
  }

  @Override
  public String toString() {
    return "apple";
  }
}
