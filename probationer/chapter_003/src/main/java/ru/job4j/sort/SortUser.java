package ru.job4j.sort;

import java.util.*;

/**
 * Class SortUser решение задачи части 003 урок 3 1.
 *
 * @author Кузенков Павел.
 * @since 24.06.2018
 */
public class SortUser {

    /**
     * Создание TreeSet со списком пользователей отсортированных по возрасту.
     * @param list Исходный список пользователей.
     * @return Отсортированный список.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<User>(new Sort());
        result.addAll(list);
        return result;
    }

    /**
     * Сортировка пользователей по длине имени.
     * @param list Исходный список пользователей.
     * @return Отсортированный список.
     */
    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new SortNameLength());
        return list;
    }

    /**
     * Сортировка пользователей по имени и возрасту.
     * @param list Исходный список пользователей.
     * @return Отсортированный список.
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new SortNameAge());
        return list;
    }
}
