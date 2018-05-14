package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class Paint решение задачи части 001 урок 5 4.3.
 *
 * @author Кузенков Павел.
 * @since 14.05.2018
 */

public class Paint {

    /**
     * Метод для построения правостороннего треугольника.
     * @param height высота треугольника
     * @return треугольник.
     */

    public String rightTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= column);
    }

    /**
     * Метод для построения левостороннего треугольника.
     * @param height высота треугольника
     * @return треугольник.
     */

    public String leftTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
    }

    /**
     * Метод для построения пирамиды.
     * @param height высота пирамиды
     * @return треугольник.
     */

    public String pyramid(int height) {
        return this.loopBy(height, 2 * height - 1, (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }

    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
