package ru.job4j.calculator;

/**
 * Class Fit решение задачи части 001 урок 3 3.3.
 *
 * @author Кузенков Павел
 * @since 12.05.2018
 */

public class Fit {

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */

    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */

    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

}
