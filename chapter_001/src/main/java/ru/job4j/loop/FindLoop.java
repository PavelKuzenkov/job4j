package ru.job4j.loop;

/**
 * Class FindLoop решение задачи части 001 урок 6 5.1.
 *
 * @author Кузенков Павел.
 * @since 14.05.2018
 */
public class FindLoop {
     public int indexOf(int[] data, int el) {
         int rst = -1;
         int totalElements = data.length;
         for (int index = 0; index != totalElements; index++) {
             if (data[index] == el) {
                 rst = index;
                 break;
             }
         }
         return rst;
     }
}
