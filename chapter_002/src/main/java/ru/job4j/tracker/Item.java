package ru.job4j.tracker;

/**
 *  Class Item решение задачи части 002 урок 3 2.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 26.05.2018
 */
public class Item {

    /**
     * Уникальный ключ заявки.
     */
    private String id;

    /**
     * Имя заявки.
     */
    private String name;

    /**
     * Описание заявки.
     */
    private String desc;


    private long created;

    /**
     * Комментарии к завке.
     */
    private String[] comments;

    /**
     * Конструктор класса.
     */
    public Item() {
    }

    /**
     * Конструктор класса.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Конструктор класса.
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    /**
     * Переопредиление метода toString.
     * @return данные по заявке.
     */
    @Override
    public String toString() {
        return
                "Имя: " + this.name
                .concat(System.lineSeparator())
                .concat("Описание: " + this.desc)
                .concat(System.lineSeparator())
                .concat("ID: " + this.id)
                .concat(System.lineSeparator());
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getCreated() {
        return this.created;
    }

    public String getDesc() {
        return this.desc;
    }
}
