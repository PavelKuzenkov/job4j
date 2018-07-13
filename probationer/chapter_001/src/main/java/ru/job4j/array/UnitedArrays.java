package ru.job4j.array;

/**
 * Class UnitedArray.
 *
 * @author Кузенков Павел.
 * @since 23.05.2018
 */
public class UnitedArrays {

    /**
     * Объединяем 2 отсортированных массива в 1.
     * @param first первый массив.
     * @param second второй массив.
     * @return отсортированный массив.
     */
    public int[] union(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int j = 0;
        for (int i = 0; i != first.length;) {
            if (first[i] < second[j]) {
                result[i + j] = first[i];
            } else {
                result[i + j] = second[j];
                j++;
                i--;
                if (j == second.length) {
                    for (int temp = i + 1; temp != first.length; temp++) {
                        result[temp + j] = first[temp];
                    }
                    break;
                }
            }
            i++;
            if (i == first.length) {
                for (int temp = j; temp != second.length; temp++) {
                    result[i + temp] = second[temp];
                }
                break;
            }
        }
        return result;
    }
}
