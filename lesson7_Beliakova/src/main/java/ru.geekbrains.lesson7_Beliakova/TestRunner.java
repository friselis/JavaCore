package ru.geekbrains.lesson7_Beliakova;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestRunner {

    public static final int MAXIMUM_PRIORITY = 10;

    public static void main(String[] args) throws Exception {
        Class test1 = Test1.class;
        start(test1);

        Class test2 = Test2.class;
        start(test2);

        Class test3 = Test3.class;
        start(test3);

        Class test4 = Test4.class;
        start(test4);

        Class test5 = Test5.class;
        start(test5);

        try {
            Class test6 = Test6.class;
            start(test6);
        } catch (Exception e) {
            System.out.println("Test 6: " + e.getMessage());
        }

        try {
            Class test7 = Test7.class;
            start(test7);
        } catch (Exception e) {
            System.out.println("Test 7: " + e.getMessage());
        }

        try {
            Class test8 = Test8.class;
            start(test8);
        } catch (Exception e) {
            System.out.println("Test 8: " + e.getMessage());
        }


    }

    static void start(Class test) throws Exception {
        Method[] methods = test.getDeclaredMethods();
        int numberOfBeforeSuite = 0;
        int numberOfAfterSuite = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                numberOfBeforeSuite++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                numberOfAfterSuite++;
            }
            if (numberOfAfterSuite > 1 || numberOfBeforeSuite > 1) {
                throw new RuntimeException("BeforeSuite or AfterSuite are presented more than once");
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(null);
            }
        }

        for (int i = 1; i <= MAXIMUM_PRIORITY; i++) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    if (method.getAnnotation(Test.class).priority() == i) {
                        method.invoke(null);
                    }
                }
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(null);
            }
        }
    }
}
