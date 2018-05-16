package ru.job4j.array;

/**
 * Class BubbleSort решение задачи части 001 урок 6 5.3.
 *
 * @author Кузенков Павел.
 * @since 15.05.2018
 */
public class BubbleSort {

    /**
     * Сортировка массива.
     * @param array исходный массив.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        int totalElements = array.length - 1;
        int temp;
        for (int i = totalElements; i > 0; i--) {
            for (int j = 0; j != i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
