package ru.job4j.profession;

/**
 * Class Engineer решение задачи части 002 урок 2 1.
 *
 * @author Кузенков Павел.
 * @since 25.05.2018
 */
public class Engineer extends Profession {

    /**
     * Постройка дома.
     * @return дом.
     */
    public House build() {
        return new House();
    }
}
