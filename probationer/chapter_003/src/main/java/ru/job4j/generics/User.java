package ru.job4j.generics;

/**
 * Class User решение задачи части 003 урок 2 2.
 *
 * @author Кузенков Павел.
 * @since 21.06.2018
 */
public class User {

    /**
     * User Id.
     */
    private String id;

    /**
     * User name.
     */
    private String name;

    /**
     * User city.
     */
    private String city;

    /**
     * Конструктор класса.
     * @param id
     * @param name
     * @param city
     */
    public User(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
