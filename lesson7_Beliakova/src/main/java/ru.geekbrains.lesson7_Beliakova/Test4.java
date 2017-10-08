package ru.geekbrains.lesson7_Beliakova;

public class Test4 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test4 before suite");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test4 after suite");
    }

}
