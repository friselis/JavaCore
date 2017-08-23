package ru.geekbrains.lesson3;

import java.io.FileInputStream;

public class Task1 {

  public static void main(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("Task1.txt");
    byte[] byteArray = new byte[in.available()];

    in.read(byteArray);

    for (byte letter : byteArray) {
      System.out.printf(letter + " ");
    }

    in.close();
  }
}
