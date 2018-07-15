package ru.job4j.array;

/**
 * Class RotatedArray.
 *
 * @author Кузенков Павел.
 * @since 23.05.2018
 */
public class RotatedArray {

    /**
     * Поворот массива на 90 градусов.
     * @param array исходный массив.
     * @return повернутый массив.
     */
    public int[][] rotate(int[][] array) {
        for (int i = 0; i != array.length / 2; i++) {
            for (int j = i; j != array.length - i - 1; j++) {
                int a = array[i][j];
                array[i][j] = array[array.length - j - 1][i];
                array[array.length - j - 1][i] = array[array.length - i - 1][array.length - j - 1];
                array[array.length - i - 1][array.length - j - 1] = array[j][array.length - i - 1];
                array[j][array.length - i - 1] = a;
            }

        }
        return array;
    }

    public static void main(String[] args) {
        RotatedArray rotatedArray = new RotatedArray();
        int[][] input = {
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
        };
        int[][] result = rotatedArray.rotate(input);
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result.length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
