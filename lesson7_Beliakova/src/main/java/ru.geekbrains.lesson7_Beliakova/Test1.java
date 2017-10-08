package ru.geekbrains.lesson7_Beliakova;

public class Test1 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test1 before suite");
    }

    @Test
    static void method1() {
        System.out.println("Test1 method1");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test1 after suite");
    }
}
