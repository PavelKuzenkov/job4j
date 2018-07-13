package ru.job4j.array;

/**
 * Class Paint решение задачи части 001 урок 6 5.0.
 *
 * @author Кузенков Павел.
 * @since 14.05.2018
 */
public class Square {

    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
