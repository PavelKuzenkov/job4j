package ru.job4j.array;

/**
 * Class Turn решение задачи части 001 урок 6 5.2.
 *
 * @author Кузенков Павел.
 * @since 15.05.2018
 */
public class Turn {

    /**
     * Метод для разворота массива.
     *
     * @param array исходный массив.
     * @return перевернутый массив.
     */
    public int[] turn(int[] array) {
        int totalElements = array.length;
        for (int i = 0; i != totalElements / 2; i++) {
            int temp = array[i];
            array[i] = array[totalElements - 1 - i];
            array[totalElements - 1 - i] = temp;
        }
        return array;
    }
}

