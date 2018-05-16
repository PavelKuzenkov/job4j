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
        return first > second ? first : second;
    }

    /**
     * Нахождение большего из трех чисел.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return максимум.
     */

    public int max(int  first, int second, int third) {
        int temp = max(first, second);
        return max(temp, third);
    }
}
