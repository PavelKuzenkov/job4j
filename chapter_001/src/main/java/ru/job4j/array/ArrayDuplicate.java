package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate решение задачи части 001 урок 6 5.6.
 *
 * @author Кузенков Павел.
 * @since 15.05.2018
 */
public class ArrayDuplicate {

    /**
     * Удаление дубликатов из массива.
     * @param array исходный массив.
     * @return массив без дублей.
     */
    public String[] remote(String[] array) {
        int notDuplicate = array.length;
        for (int i = 0; i < notDuplicate; i++) {
            for (int j = i + 1; j < notDuplicate; j++) {
                    if (array [i].equals(array[j])) {
                        notDuplicate--;
                        for (int duplicate = j; duplicate < notDuplicate; duplicate++) {
                            array[duplicate] = array[duplicate + 1];
                        }
                        j--;
                    }
            }
        }
        return Arrays.copyOf(array, notDuplicate);
    }
}
