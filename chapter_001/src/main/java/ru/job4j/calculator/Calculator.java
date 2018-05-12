package ru.job4j.calculator;

/**
 * Class Calculator решение задачи части 001 урок 3 3.1.
 *
 * @author Кузенков Павел
 * @since 11.05.2018
 */

public class Calculator {

    /**
     * Поле для хранения результатов вычислений.
     */

    double result;

    /**
     * Метод add для сложения двух чисенл.
     * @param first первое число.
     * @param second второе число.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод subtract для вычитания второго числа из первого.
     * @param first первое число.
     * @param second второе число.
     */

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод div для деления первого числа на второе.
     * @param first первое число.
     * @param second второе число.
     */

    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод multiple для умножения двух чисенл.
     * @param first первое число.
     * @param second второе число.
     */

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод getResult возвращает значение поля result.
     * @return result
     */

    public double getResult() {
        return this.result;
    }

}
