package ru.geekbrains.race;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {

  public static final int CARS_COUNT = 4;
  private static final int RACES_COUNT = 3;
  public static CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT, () -> {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
  });
  public static CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT * RACES_COUNT);
  public static volatile int WIN_FLAG = 1;

  public static void main(String[] args) {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    Race race = new Race(new Road(60), new Tunnel(), new Road(40));
    Car[] cars = new Car[CARS_COUNT];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
    }
    for (int i = 0; i < cars.length; i++) {
      new Thread(cars[i]).start();
    }

    while (countDownLatch.getCount() > 0) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
  }
}

