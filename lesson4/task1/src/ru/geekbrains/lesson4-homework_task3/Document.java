package ru.geekbrains.ru.geekbrains.lesson4_homework_task3;

public class Document {
    private final int size;
    private final String name;

  Document(String name, int size) {
    this.size = size;
    this.name = name;
  }

  public int getSize() {
    return size;
  }

  public String getName() {
    return name;
  }

}
