package ru.job4j.loop;

/**
 * Class Board решение задачи части 001 урок 5 4.3.
 *
 * @author Кузенков Павел.
 * @since 14.05.2018
 */
public class Board {

    /**
     * Построение шахматной доски.
     * @param widht ширина доски.
     * @param height высота доски.
     * @return шахматная доска.
     */
    public String paint(int widht, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int j = 1; j <= height; j++) {
            for (int i = 1; i <= widht; i++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
