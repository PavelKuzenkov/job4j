package ru.job4j.search;

/**
 * Class Task решение задачи части 003 урок 1 2.
 *
 * @author Кузенков Павел.
 * @since 18.06.2018
 */
public class Task {

    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
