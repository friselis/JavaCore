package ru.geekbrains.lesson6_homework;

public class Task2 {

    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 4;

    public static boolean checkArray(int[] input) {
        int numOnes = 0;
        int numTwos = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == NUMBER_ONE) {
                numOnes++;
            }
            if (input[i] == NUMBER_TWO) {
                numTwos++;
            }
            if (input[i] != NUMBER_ONE && input[i] != NUMBER_TWO) {
                return false;
            }
        }
        return numOnes != 0 && numTwos != 0;
    }
}
