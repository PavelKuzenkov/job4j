package ru.job4j.array;

/**
 * Class Matrix решение задачи части 001 урок 6 5.4.
 *
 * @author Кузенков Павел.
 * @since 15.05.2018
 */

public class Matrix {

    /**
     * Создание таблицы умножения.
     * @param size размер таблицы.
     * @return таблица умножения.
     */

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i != size; i++) {
            for (int j = 0; j != size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
