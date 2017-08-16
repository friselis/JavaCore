package ru.geekbrains.fruits;


public class Main {

  public static void main(String[] args) {
    Box<Apple> boxOfApples = new Box<>();
    Box<Orange> boxOfOranges = new Box<>();
    boxOfApples.put(new Apple());
    boxOfApples.put(new Apple());
    boxOfApples.put(new Apple());
    boxOfOranges.put(new Orange());
    boxOfOranges.put(new Orange());
    System.out.println(boxOfApples.compare(boxOfOranges));
    Box<Apple> anotherBoxOfApples = new Box<>();
    anotherBoxOfApples.put(new Apple());
    boxOfApples.moveTo(anotherBoxOfApples);
    System.out.println(boxOfApples);
    System.out.println(anotherBoxOfApples);
  }
}
