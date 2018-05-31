package ru.job4j.pseudo;

/**
 *  Class Paint решение задачи части 002 урок 4 4.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 31.05.2018
 */
public class Paint {

    /**
     * Вывод в консоль фигуры.
     * @param shape фигура, которую нужно вывести в консоль.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
