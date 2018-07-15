package ru.job4j.pseudo;

/**
 * Class Triangle решение задачи части 002 урок 4 4.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 31.05.2018
 */
public class Triangle implements Shape {

    /**
     * Построение фигуры.
     * @return фигура в виде строки.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+   ");
        pic.append("++  ");
        pic.append("+ + ");
        pic.append("++++");
        return pic.toString();
    }
}
