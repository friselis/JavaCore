package ru.geekbrains.ru.geekbrains.lesson4_homework_task3;

public class MFD {

  private final Object monitor1 = new Object();
  private final Object monitor2 = new Object();

  public void scan(Document document) {
    synchronized (monitor1) {
      for (int i = 0; i < document.getSize(); i++) {
        System.out.println("Scanning document " + document.getName() + " page " + (i + 1));
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void scanAsync(Document document) {
    new Thread(() -> {
      scan(document);
    }).start();
  }

  public void print(Document document) {
    synchronized (monitor2) {
      for (int i = 0; i < document.getSize(); i++) {
        System.out.println("Printing document " + document.getName() + " page " + (i + 1));
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void printAsync(Document document) {
    new Thread(() -> {
      print(document);
    }).start();
  }
}
