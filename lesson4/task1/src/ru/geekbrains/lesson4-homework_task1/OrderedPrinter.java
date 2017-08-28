package ru.geekbrains.lesson4_homework_task1;

public class OrderedPrinter {

  private volatile char currentLetter;

  OrderedPrinter(char currentLetter) {
    this.currentLetter = currentLetter;
  }

  public synchronized void setCurrentLetter(char currentLetter) {
    this.currentLetter = currentLetter;
    notifyAll();
  }

  public synchronized void waitUntilCurrentLetterIs(char letter) {
    while (currentLetter != letter) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public synchronized void printCurrentLetter() {
    System.out.print(currentLetter);
  }
}
