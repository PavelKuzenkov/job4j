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
        int value = 1;
        for (int i = 0; i != bound; i++) {
            rst[i] = value * value;
            value++;
        }
        return rst;
    }
}
