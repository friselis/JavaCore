package ru.geekbrains.lesson7_Beliakova;

public class Test8 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test8 before suite");
    }

    @BeforeSuite
    static void methodBeforeSuite1() {
        System.out.println("Test8 before suite #2");
    }

    @Test
    static void method1() {
        System.out.println("Test8.method1");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test8 after suite");
    }

}
