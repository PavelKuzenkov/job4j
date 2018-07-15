package ru.job4j.sort;

/**
 * Class User решение задачи части 003 урок 3 1.
 *
 * @author Кузенков Павел.
 * @since 24.06.2018
 */
public class User {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Возраст пользователя.
     */
    private String age;

    /**
     * конструктор класса.
     * @param name Имя пользователя.
     * @param age Возраст пользователя.
     */
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Переопредиление метода toString
     * @return данные пользователя
     */
    @Override
    public String toString() {
        return
                "Имя: " + this.name
                .concat(System.lineSeparator())
                .concat("Возраст: " + this.age)
                .concat(System.lineSeparator());
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
