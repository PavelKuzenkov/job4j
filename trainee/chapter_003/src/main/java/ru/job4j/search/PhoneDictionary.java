package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary решение задачи части 003 урок 1 1.
 *
 * @author Кузенков Павел.
 * @since 13.06.2018
 */
public class PhoneDictionary {

    /**
     * Список пользователей.
     */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Добавление нового пользователя.
     * @param person новый пользователь.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person != null
               && (person.getName().contains(key)
               || person.getSurname().contains(key)
               || person.getAddress().contains(key)
               || person.getPhone().contains(key))) {
               result.add(person);
            }
        }
        return result;
    }

}
