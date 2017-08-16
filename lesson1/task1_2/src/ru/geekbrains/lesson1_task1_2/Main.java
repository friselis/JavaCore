package ru.geekbrains.lesson1_task1_2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

  private static String[] arr = {"a1", "a2","a3"};

  public static void main(String[] args) {
    task1();
    //arrayList();
  }

  private static void task1() {
    swapElements(arr, 1, 0 );
    for (String element : arr) {
      System.out.printf(element + " ");
    }
  }

  private static void arrayList() {
    System.out.println("ArrayList: " + getArrayList(arr));
  }

  private static <T> ArrayList<T> getArrayList(T[] array) {
    ArrayList<T> resultList = new ArrayList<>();
    Collections.addAll(resultList, array);
    return resultList;
  }

  private static <T> void swapElements(T[] arr, int firstIndex, int secondIndex) {
    T tmp = arr[firstIndex];
    arr[firstIndex] = arr[secondIndex];
    arr[secondIndex] = tmp;
  }
}
