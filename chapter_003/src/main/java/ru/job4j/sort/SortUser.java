package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
