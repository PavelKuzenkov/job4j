package ru.job4j.tracker;

import java.util.Scanner;

/**
 *  Class ConsoleInput решение задачи части 002 урок 4 1.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 28.05.2018
 */

public class ConsoleInput implements Input {

    private Scanner input = new Scanner(System.in);

    /**
     * Работа с консолью.
     * @param quastion вопрос от программы.
     * @return ввод пользователя в консоль.
     */
    public String ask(String quastion) {
        System.out.println(quastion);
        return this.input.nextLine();
    }
}
