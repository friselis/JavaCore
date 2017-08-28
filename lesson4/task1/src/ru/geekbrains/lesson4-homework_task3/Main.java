package ru.geekbrains.ru.geekbrains.lesson4_homework_task3;

public class Main {

  public static void main(String[] args) {
    MFD mfd1 = new MFD();
    mfd1.scanAsync(new Document("1", 2));
    mfd1.printAsync(new Document("2", 10));
    new Thread(() -> {
      mfd1.scan(new Document("3", 5));
    }).start();
    new Thread(() -> {
      mfd1.print(new Document("4", 7));
    }).start();
  }
}
