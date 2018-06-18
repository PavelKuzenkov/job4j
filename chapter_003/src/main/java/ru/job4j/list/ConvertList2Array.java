package ru.job4j.list;

import java.util.List;

/**
 * Class ConvertList2Array решение задачи части 003 урок 1 3.
 *
 * @author Кузенков Павел.
 * @since 18.06.2018
 */
public class ConvertList2Array {

    /**
     * Конвертация ArrayList в двухмерный массив с заданным количеством строк.
     * @param list исходный ArrayList.
     * @param rows требуемое количество строк на выходе.
     * @return массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((float) list.size() / rows);
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int i = 0; i != rows; i++) {
            for (int j = 0; j != cells; j++) {
                if (index != list.size()) {
                    array[i][j] = list.get(index++);
                } else array[i][j] = 0;
            }
        }
        return array;
    }
}
