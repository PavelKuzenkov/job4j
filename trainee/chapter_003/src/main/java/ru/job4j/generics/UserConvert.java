package ru.job4j.generics;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert решение задачи части 003 урок 2 2.
 *
 * @author Кузенков Павел.
 * @since 21.06.2018
 */
public class UserConvert {

    /**
     * Конвертация листа пользователей в HashMap.
     * @param list Исходный лист.
     * @return Результат HashMap.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(Integer.parseInt(user.getId()), user);
        }
        return result;
    }
}
