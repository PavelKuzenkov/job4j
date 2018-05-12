package ru.job4j.converter;

/**
 * Class Converter решение задачи части 001 урок 3 3.2.
 *
 * @author Кузенков Павел
 * @since 12.05.2018
 */

public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */

    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары.
     */

    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */

    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */

    public int dollarToRuble(int value) {
        return value * 60;
    }
}
