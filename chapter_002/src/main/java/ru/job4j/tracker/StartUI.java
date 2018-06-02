package ru.job4j.tracker;

import java.util.Arrays;

/**
 *  Class StartUI решение задачи части 002 урок 4 1.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 28.05.2018
 */
public class StartUI {

    /**
     * Индикатор работы программы.
     * Программа работает до тех пор, пока заначение ложно.
     */
    private boolean exit;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Диапозон пунктов меню.
     */
    private int[] range = new int[10];

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.exit = false;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        while (!this.exit) {
            menu.show();
            menu.select(input.ask("Select: ", this.range));
        }
    }

    /**
     * Выход из программы.
     */
    public void exit() {
        this.exit = true;
    }

    public void setRange(int range) {
        for (int index = 0; index != range; index++) {
            this.range[index] = index;
        }
        this.range = Arrays.copyOf(this.range, range);
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}