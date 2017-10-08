package ru.geekbrains.lesson7_Beliakova;

public class Test5 {

    @BeforeSuite
    static void methodBeforeSuite() {
        System.out.println("Test5 before suite");
    }

    @Test
    static void method1() {
        System.out.println("Test5.method1, default priority");
    }

    @Test(priority = 2)
    static void method2() {
        System.out.println("Test5.method2, priority = 2");
    }

    @Test(priority = 4)
    static void method3() {
        System.out.println("Test5.method3, priority = 4");
    }

    @Test(priority = 3)
    static void method4() {
        System.out.println("Test5.method4, priority = 3");
    }

    @AfterSuite
    static void methodAfterSuite() {
        System.out.println("Test5 after suite");
    }

}
