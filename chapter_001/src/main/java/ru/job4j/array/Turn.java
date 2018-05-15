package ru.job4j.array;

/**
 * Class Turn решение задачи части 001 урок 6 5.2.
 *
 * @author Кузенков Павел.
 * @since 15.05.2018
 */

public class Turn {

    public int[] turn(int[] array) {
        int totalElements = array.length;
        int temp;
        if (totalElements % 2 == 0) {
            for (int i = 0; i != totalElements / 2; i++) {
                temp = array[i];
                array[i] = array[totalElements - 1 - i];
                array[totalElements - 1 - i] = temp;
            }
            return array;
        }
        for (int i = 0; i != (totalElements - 1) / 2; i++) {
            temp = array[i];
            array[i] = array[totalElements - 1 - i];
            array[totalElements - 1 - i] = temp;
        }
        return array;
    }
}
