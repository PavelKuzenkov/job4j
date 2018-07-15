package ru.job4j.sort;

import java.util.Comparator;

/**
 * Class SortNameLength решение задачи части 003 урок 3 2.
 *
 * @author Кузенков Павел.
 * @since 24.06.2018
 */
public class SortNameLength implements Comparator<User> {

    /**
     * Переопределение метода compare.
     * @param o1 Первый элемент для сравнения.
     * @param o2 Второй элемент для сравнения.
     * @return результат сравнения.
     */
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
