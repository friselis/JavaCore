package ru.geekbrains.lesson3;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task3 {

  private static final int PAGE_SIZE = 1800;
  private static final String HELP_MESSAGE = "showPage FILE_PATH PAGE_NUMBER - "
      + "show a PAGE_NUMBER page of the file from the FILE_PATH";

  public static void main(String[] args) {
    Scanner fileRead = new Scanner(System.in);
    String nextCommand = fileRead.nextLine();
    String[] commandArgs = nextCommand.split(" ");

    while (!commandArgs[0].equals("disconnect")) {
      switch (commandArgs[0]) {
        case "showPage":
          try {
            String page = readFile(commandArgs[1], Integer.parseInt(commandArgs[2]));
            System.out.println(page);
          } catch (Exception e) {
            System.out.println("Wrong arguments.");
            System.out.println(HELP_MESSAGE);
          }
          break;
        case "?":
          System.out.println(HELP_MESSAGE);
          break;
        default:
          System.out.println("Command not found.");
          System.out.println(HELP_MESSAGE);
      }
      nextCommand = fileRead.nextLine();
      commandArgs = nextCommand.split(" ");
    }
  }

  private static String readFile(String filePath, int pageNumber) throws Exception {
    int symbolsToSkip =  PAGE_SIZE * (pageNumber - 1);
    RandomAccessFile doc = new RandomAccessFile(filePath, "r");
    doc.seek(symbolsToSkip);
    byte[] output = new byte[PAGE_SIZE];
    doc.read(output, 0, PAGE_SIZE);
    return new String(output, StandardCharsets.UTF_8);
  }
}
