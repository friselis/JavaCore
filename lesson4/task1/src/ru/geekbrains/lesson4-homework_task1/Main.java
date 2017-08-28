package ru.geekbrains.lesson4_homework_task1;

public class Main {

  private static final char LETTER_A = 'A';
  private static final char LETTER_B = 'B';
  private static final char LETTER_C = 'C';
  private static final int NUMBER_OF_ITERATIONS = 5;


  public static void main(String[] args) {
    OrderedPrinter printer = new OrderedPrinter(LETTER_A);

    Thread t1 = new Thread(() -> {
      runJob(printer, LETTER_A, LETTER_B);
    });

    Thread t2 = new Thread(() -> {
      runJob(printer, LETTER_B, LETTER_C);
    });

    Thread t3 = new Thread(() -> {
      runJob(printer, LETTER_C, LETTER_A);
    });

    t1.start();
    t2.start();
    t3.start();
    try {
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void runJob(OrderedPrinter printer, char currentLetter, char nextLetter) {
    for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
      printer.waitUntilCurrentLetterIs(currentLetter);
      printer.printCurrentLetter();
      printer.setCurrentLetter(nextLetter);
    }
  }
}
