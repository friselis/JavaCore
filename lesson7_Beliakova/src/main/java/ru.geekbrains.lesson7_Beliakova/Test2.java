package ru.geekbrains.lesson7_Beliakova;

public class Test2 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test2 before suite");
    }

    @Test
    static void method1() {
        System.out.println("Test2 method1, default priority");
    }

    @Test(priority = 2)
    static void method2() {
        System.out.println("Test2 method2, priority = 2");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test2 after suite");
    }
}
