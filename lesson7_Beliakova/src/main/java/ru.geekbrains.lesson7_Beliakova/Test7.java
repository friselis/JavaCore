package ru.geekbrains.lesson7_Beliakova;

public class Test7 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test7 before suite");
    }

    @BeforeSuite
    static void methodBeforeSuite1() {
        System.out.println("Test7 before suite #2");
    }

    @Test
    static void method1() {
        System.out.println("Test7.method1");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test7 after suite");
    }

    @AfterSuite
    static void methodAfterSuite1() {
        System.out.println("Test7 after suite # 2");
    }

}
