package ru.job4j.sort;

import java.util.Comparator;

/**
 * Class Sort решение задачи части 003 урок 3 1.
 *
 * @author Кузенков Павел.
 * @since 24.06.2018
 */
public class Sort implements Comparator<User> {

    /**
     * Переопределение метода compare.
     * @param o1 Первый элемент для сравнения.
     * @param o2 Второй элемент для сравнения.
     * @return результат сравнения.
     */
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(Integer.parseInt(o1.getAge()), Integer.parseInt(o2.getAge()));
    }
}
