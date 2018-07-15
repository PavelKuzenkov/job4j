package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConvertMatrix2List решение задачи части 003 урок 1 4.
 *
 * @author Кузенков Павел.
 * @since 18.06.2018
 */
public class ConvertMatrix2List {

    /**
     * Конвертация двухмерного массива в ArrayList.
     * @param array исходный массив.
     * @return ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] value : array) {
            for (int value1 : value) {
                result.add(value1);
            }
        }
        return result;
    }
}
