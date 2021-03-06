package ru.job4j.tracker;

/**
 *  Class ValidateInput решение задачи части 002 урок 6 1.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 02.06.2018
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Проверка корректности вводимых пользователем команд в меню.
     * @param question вопрос от программы.
     * @param range диапозон допустимых значений команд.
     * @return ввод пользователя в консоль.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Необходимо выбрать значение из диапазона меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Необходимо ввести корректное значение.");
            }
        } while (invalid);
        return value;
    }
}
