package ru.job4j.sort;

import java.util.Comparator;

public class SortNameAge implements Comparator<User> {

    /**
     * Переопределение метода compare.
     * @param o1 Первый элемент для сравнения.
     * @param o2 Второй элемент для сравнения.
     * @return результат сравнения.
     */
    @Override
    public int compare(User o1, User o2) {
        int sort = o1.getName().compareTo(o2.getName());
        return sort != 0 ? sort : o1.getAge().compareTo(o2.getAge());
    }
}
