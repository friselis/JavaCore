package ru.geekbrains.lesson6_homework;

import java.util.Arrays;

public class Task1 {

  private static final int LAST_NUMBER = 4;

  public static int[] getArray(int[] input) throws RuntimeException {
    for (int i = input.length - 1; i >= 0; i--) {
      if (input[i] == LAST_NUMBER) {
        int[] output = new int[input.length - i - 1];
        for (int j = 0; j < output.length; j++) {
          output[j] = input[i + 1];
          i++;
        }
        return output;
      }
    }
    throw new RuntimeException("4 expected but not found in: " + Arrays.toString(input));
  }
}
