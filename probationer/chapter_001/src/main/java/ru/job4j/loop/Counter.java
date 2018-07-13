package ru.job4j.loop;

/**
 * Class Counter решение задачи части 001 урок 5 4.1.
 *
 * @author Кузенков Павел
 * @since 13.05.2018
 */
public class Counter {

    /**
     * Метод вычисляет сумму четных чисел в диапазоне от start до finish.
     * @param start первое число.
     * @param finish второе число.
     * @return сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
