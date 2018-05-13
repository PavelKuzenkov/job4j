package ru.job4j.max;

/**
 * Class Max решение задачи части 001 урок 4 3.2.
 *
 * @author Кузенков Павел
 * @since 13.05.2018
 */

public class Max {

    /**
     * Нахождение большего из двух чисел.
     * @param first первое число.
     * @param second второе число.
     * @return максимум.
     */

    public int max(int first, int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public int max(int  first, int second, int third) {
        int temp = max(first, second);
        return max(temp, third);
    }
}
