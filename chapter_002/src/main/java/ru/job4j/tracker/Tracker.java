package ru.job4j.tracker;

import java.util.Arrays;
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
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public void add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                change.setId(items[index].getId());
                this.items[index] = change;
                break;
            }
        }
    }

    /**
     * Удаление заявок.
     * @param id уникальный ключ заявки, которую нужно удалить.
     */
    public void delete(String id) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.position - index - 1);
                this.position--;
                break;
            }
        }
    }

    /**
     * Получение списка всех заявок.
     * @return список всех заявок.
     */
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        System.arraycopy(this.items, 0, result, 0, this.position);
        return result;
    }

    /**
     * Получение списка по имени.
     * @param key имя требуемой заявки.
     * @return список всех заявок с таким именем.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int index = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().contains(key)) {
                result[index++] = item;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * Получение заявки по id.
     * @param id уникальный ключ заявки, которую нужно заменить.
     * @return найденная заявка.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}