package ru.job4j.loop;

import java.util.Map;

/**
 * Class Factorial решение задачи части 001 урок 5 4.2.
 *
 * @author Кузенков Павел
 * @since 13.05.2018
 */
public class Factorial {

    /**
     * Метод для вычисления факториала.
     * @param n число для которого нужно вычислить факториал.
     * @return факториал.
     */
    public int calc(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int recursion(int n) {
        if (n == 1) {
            return 1;
        }
        return recursion(n - 1) * n;
    }
    public static void main(String[] args) {
        System.out.println(recursion(10)); // вызов рекурсивной функции
    }
}