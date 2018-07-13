package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Class Tracker решение задачи части 002 урок 3 2.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 26.05.2018
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Редактирование заявок.
     * @param id уникальный ключ заявки, которую нужно заменить.
     * @param change новая заявка.
     */
    public void replace(String id, Item change) {
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                change.setId(item.getId());
                this.items.remove(item);
                this.items.add(change);
                break;
            }
        }
    }

    /**
     * Удаление заявок.
     * @param id уникальный ключ заявки, которую нужно удалить.
     */
    public void delete(String id) {
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }

    /**
     * Получение списка всех заявок.
     * @return список всех заявок.
     */
    public ArrayList<Item> getAll() {
        return this.items;
    }

    /**
     * Получение списка по имени.
     * @param key имя требуемой заявки.
     * @return список всех заявок с таким именем.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item item : this.items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Получение заявки по id.
     * @param id уникальный ключ заявки, которую нужно заменить.
     * @return найденная заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}