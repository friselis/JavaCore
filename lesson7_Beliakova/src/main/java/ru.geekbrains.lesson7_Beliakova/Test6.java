package ru.geekbrains.lesson7_Beliakova;

public class Test6 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test6 before suite");
    }

    @Test
    static void method1() {
        System.out.println("Test6.method1");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test6 after suite");
    }

    @AfterSuite
    static void methodAfterSuite1() {
        System.out.println("Test6 after suite # 2");
    }
}
