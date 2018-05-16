package ru.job4j.array;

/**
 * Class ArrayChar решение задачи части 001 урок 6 5.5.
 *
 * @author Кузенков Павел.
 * @since 15.05.2018
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        int totalElements = value.length;
        for (int i = 0; i != totalElements; i++) {
            if (this.data[i] == value[1]) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}