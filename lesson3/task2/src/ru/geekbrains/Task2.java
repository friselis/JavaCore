package ru.geekbrains.lesson3;

import java.io.FileInputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Task2 {

  public static void main(String[] args) throws Exception {
    ArrayList<FileInputStream> files = new ArrayList<>();
    files.add(new FileInputStream("task2_1.txt"));
    files.add(new FileInputStream("task2_2.txt"));
    files.add(new FileInputStream("task2_3.txt"));
    files.add(new FileInputStream("task2_4.txt"));
    files.add(new FileInputStream("task2_5.txt"));

    SequenceInputStream concatenated = new SequenceInputStream(Collections.enumeration(files));

    int x;
    while ((x = concatenated.read()) != -1) {
      System.out.print((char) x);
    }

    concatenated.close();
  }
}
