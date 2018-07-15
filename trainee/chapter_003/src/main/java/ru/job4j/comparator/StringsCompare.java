package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Class StringsCompare решение задачи части 003 урок 3 3.
 *
 * @author Кузенков Павел.
 * @since 25.06.2018
 */
public class StringsCompare implements Comparator<String> {

    /**
     * Переопределение метода compare.
     * @param left первая строка.
     * @param right вторая строка.
     * @return результат сравнения.
     */
    @Override
    public int compare(String left, String right) {
        int minLength = left.length() < right.length() ? left.length() : right.length();
        int result = 0;
        for (int index = 0; index != minLength; index++) {
            result = Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                break;
            }
        }
       if (result == 0 && left.length() != right.length()) {
            result = left.length() < right.length() ? -1 : 1;
       }
        return result;
    }
}
