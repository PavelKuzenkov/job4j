package ru.job4j.tracker;

/**
 *  Class MenuOutException решение задачи части 002 урок 6 1.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 02.06.2018
 */
public class MenuOutException extends RuntimeException {

    /**
     * Принимаем сообщение об ошибке в конструктор и передаем
     * его в конструктор родителя.
     * @param msg Сообщение об ошибке.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
