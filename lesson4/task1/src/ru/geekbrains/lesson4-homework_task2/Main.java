package ru.geekbrains.lesson4_homework_task2;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

  private static final int NUMBER_OF_ITERATIONS = 10;

  public static void main(String[] args) throws Exception {

    FileWriter fileWriter = new FileWriter("output.txt", false);

    Thread t1 = createFileWriterThread(fileWriter, "1");
    Thread t2 = createFileWriterThread(fileWriter, "2");
    Thread t3 = createFileWriterThread(fileWriter, "3");

    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();
    fileWriter.close();
  }

  public static Thread createFileWriterThread(FileWriter fileWriter, String line) {
    return new Thread(() -> {
      for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
        try {
          fileWriter.write(line + "\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
