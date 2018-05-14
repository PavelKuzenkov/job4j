package ru.job4j.loop;

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
        if (n == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}