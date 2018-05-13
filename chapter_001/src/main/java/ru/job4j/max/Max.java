package ru.job4j.max;

/**
 * Class Condition решение задачи части 001 урок 4 3.2.
 *
 * @author Кузенков Павел
 * @since 13.05.2018
 */

public class Max {

    public int max(int first, int second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }
}
