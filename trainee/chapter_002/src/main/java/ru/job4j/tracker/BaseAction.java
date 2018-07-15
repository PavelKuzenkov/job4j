package ru.job4j.tracker;

/**
 *  Class BaseAction решение задачи части 002 урок 7 1.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 05.06.2018
 */
public abstract class BaseAction implements UserAction {

    /**
     * Номер действия.
     */
    private final int key;
    /**
     * Описание действия.
     */

    private final String name;

    /**
     * Конструктор класса.
     * @param key номер действия.
     * @param name описание действия.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Действие пользователя.
     * @return номер действия в меню.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Описания действия.
     * @return описание действия.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
