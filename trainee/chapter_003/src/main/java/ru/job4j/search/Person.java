package ru.job4j.search;

/**
 * Class Person решение задачи части 003 урок 1 1.
 *
 * @author Кузенков Павел.
 * @since 13.06.2018
 */
public class Person {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Фамилия пользователя.
     */
    private String surname;

    /**
     * Телефон пользователя.
     */
    private String phone;

    /**
     * Адрес пользователя.
     */
    private String address;

    /**
     * Конструктор класса (иициализация учетной записи).
     * @param name имя.
     * @param surname фамилия.
     * @param phone телефон.
     * @param address адрес.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }
}
